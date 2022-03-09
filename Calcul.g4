grammar Calcul;

@parser::members {

    private int _cur_label = 1;
    /** générateur de nom d'étiquettes pour les boucles */
    private String getNewLabel() { return "Label" +(_cur_label++); }

    private TableSymboles tableSymboles = new TableSymboles();

    private String evalexpr (String op) { // On utilise evalexpr pour la priorité (on ne peu pas déroulé les opération)
        if ( op.equals("*") ){
            return "MUL\n";
        } else if ( op.equals("+") ){
            return "ADD\n";
        } else if ( op.equals("-") ){
            return "SUB\n";
        } else if ( op.equals("/") ){
            return "DIV\n";
        } else {
           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
        }
    }
    private String evalop (String op) { //evalop est utilsé pour les opérateur relationnels
      if ( op.equals("==")){
        return "EQUAL\n";
      } else if( op.equals("!=")){
        return "NEQ\n";
      } else if( op.equals(">")){
        return "SUP\n";
      } else if( op.equals(">=")){
        return "SUPEQ\n";
      } else if( op.equals("<")){
        return "INF\n";
      } else if (op.equals("<=")){
        return "INFEQ\n";
      } else {
        System.err.println("Opérateur relationnels incorrect : '"+op+"'");
        throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
      }
    }
    private String evallogique(String op){ // Fonction utilisé pour les expressions logique
      if(op.equals("!")){
        return "PUSHI 1\n" + "NEQ\n"; //Pour inverser on regarde si c'est différent de 1
      }
      else if(op.equals("&&")){
        return "ADD\n" + "PUSHI 2\n" + "EQUAL\n";
      }
      else if(op.equals("||")){
        return "ADD\n" + "PUSHI 1\n" + "SUPEQ\n";
      }
      else {
        System.err.println("Opérateur relationnels incorrect : '"+op+"'");
        throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
      }
    }
}

start : calcul EOF;

calcul returns [ String code ]
@init{ $code = new String();}   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*

        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "HALT\n"; }
    ;

instruction returns [ String code ]
    : '{' {$code = "";} ( a=instruction {$code += $a.code;} ) *  '}'
    | expression finInstruction
        {
          $code = $expression.code;
        }
    | boucle_while
    {
      $code = $boucle_while.code;
    }
    | branchement
    {
      $code = $branchement.code;
    }
    | repetition
    {
      $code = $repetition.code;
    }
    | condition finInstruction
    {
      $code = $condition.code;
    }
    | assignation finInstruction
        {
            $code = $assignation.code;
        }
    | read finInstruction
        {
            $code = $read.code;
        }
    | write finInstruction
        {
            $code = $write.code;
        }
    | finInstruction
    {
      $code="";
    }
    ;

expression returns [ String code ]
    : '-' a=expression {$code = $a.code + "PUSHI -1\n" + "MUL\n";}
    | a=expression op=('*'|'/') b=expression {$code = $a.code + $b.code + evalexpr($op.text);}
    | a=expression op=('+'|'-') b=expression {$code = $a.code + $b.code + evalexpr($op.text);}
    | '(' a=expression ')' {$code = $a.code;}
    | ENTIER {$code = "PUSHI " + $ENTIER.int + "\n";}
    | IDENTIFIANT
      {
        AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
        $code = "PUSHG " + at.adresse + "\n";
      }
    ;


decl returns [ String code ]
    :
        'var' IDENTIFIANT ':' TYPE  finInstruction
        {
            $code = "PUSHI 0\n";
            tableSymboles.putVar($IDENTIFIANT.text,"int");//TODO mettre aussi double (changer int)
        }
    |
        'var' IDENTIFIANT ':' TYPE '=' ENTIER finInstruction
        {
            $code = "PUSHI " + $ENTIER.text + "\n";
            tableSymboles.putVar($IDENTIFIANT.text,"int");
        }
    ;

assignation returns [ String code ]
    : IDENTIFIANT '=' expression
        {
            AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code + "STOREG " + at.adresse + "\n";
        }
    |
      IDENTIFIANT '+=' expression
        {
          AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
          $code = $expression.code + "PUSHG " + at.adresse + "\n" + "ADD\n" + "STOREG " + at.adresse + "\n";
        }
      ;

read returns [ String code ]
    : 'read(' IDENTIFIANT ')'
      {
        AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
        $code = "READ\n" + "STOREG " + at.adresse + "\n";
      }
    ;

write returns [ String code ]
    : 'write(' expression ')'
      {
        $code = $expression.code + "WRITE\n" + "POP\n";
      }
    ;

boucle_while returns [ String code ]
    : 'while' '(' condition ')' instruction
      {
        String debut = getNewLabel();
        String fin = getNewLabel();
        $code = "LABEL " + debut + "\n" +
          $condition.code +
          "JUMPF " + fin + "\n" +
          $instruction.code +
          "JUMP " + debut + "\n" +
          "LABEL " + fin + "\n";
      }
    ;

repetition returns [ String code ]
  : 'for' '(' i = assignation ';' condition ';' inc = assignation ')' instruction
    {
      String debut = getNewLabel();
      String fin = getNewLabel();
      $code = $i.code +
      "LABEL " + debut + "\n" +
      $condition.code +
      "JUMPF " + fin + "\n" +
      $instruction.code +
      $inc.code +
      "JUMP " + debut + "\n" +
      "LABEL " + fin + "\n"
      ;
    }
  | 'repeat' instruction finInstruction? 'until' '(' condition ')'
    {
      String debut = getNewLabel();
      String fin = getNewLabel();
      $code = "LABEL " + debut + "\n" +
      $condition.code + evallogique("!") +
      "JUMPF " + fin + "\n" +
      $instruction.code +
      "JUMP " + debut + "\n" +
      "LABEL " + fin + "\n";
    }
  ;

condition returns [String code]
    : NOT condition {$code = $condition.code + evallogique($NOT.text);}
    | a=condition AND b=condition {$code = $a.code + $b.code + evallogique($AND.text);}
    | a=condition OR b=condition {$code = $a.code + $b.code + evallogique($OR.text);}
    | c=expression op=OPERATEUR d=expression {$code = $c.code + $d.code + evalop($op.text);}
    | 'true' { $code = "PUSHI 1\n";}
    | 'false' {$code = "PUSHI 0\n";}
    ;

branchement returns [String code]
    : 'if' '(' condition ')' a = instruction finInstruction? 'else' b = instruction //? soit une fois sois aucune (si jamais il-y-a une fin d'instruction)
    {
      String finIf = getNewLabel();
      String finElse = getNewLabel();

      $code = $condition.code +
      "JUMPF " + finIf + "\n" +
      $a.code +
      "JUMP " + finElse + "\n"+
      "LABEL " + finIf + "\n" +
      $b.code +
      "LABEL " + finElse + "\n";
    }
    | 'if' '(' condition ')' instruction
      {
        String fin = getNewLabel();
        $code = $condition.code +
          "JUMPF " + fin + "\n" +
          $instruction.code +
          "LABEL " + fin + "\n";
      }
    ;

//lexer

finInstruction : ( NEWLINE | ';' )+ ;

TYPE : 'int' | 'double' ;

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

IDENTIFIANT : (('A' .. 'Z') | ('a' .. 'z'))+;

OPERATEUR : ('=='|'!='|'<>'|'<'|'>'|'<='|'>=');

AND : '&&';

OR : '||';

NOT : '!';

COMMENTAIRE
    : (('//')+~('\n')+ | ('/*').*?('*/') | ('%')+~('\n')+ ) -> skip;

UNMATCH : . -> skip ;
