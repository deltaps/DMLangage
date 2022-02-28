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
    private String evalop (String op) {
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
    : 'write(' IDENTIFIANT ')'
      {
        AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
        $code = "PUSHG " + at.adresse + "\n" + "WRITE\n" + "POP\n";
      }
    ;

boucle_while returns [ String code ]
    /* 'while' '(' condition ')' '{' instruction '}'
      {
        String debut = getNewLabel();
        String fin = getNewLabel();
        $code = "LABEL " + debut + "\n" + $condition.code + "JUMPF " + fin + "\n" + $instruction.code + "JUMP " + debut + "\n" + "LABEL " + fin + "\n";
      }*/
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

condition returns [String code]
    : a=expression op=OPERATEUR b=expression {$code = $a.code + $b.code + evalop($op.text);}
    | 'true' { $code = "PUSHI 1\n";}
    | 'false' {$code = "PUSHI 0\n";}
    ;


//lexer

finInstruction : ( NEWLINE | ';' )+ ;

TYPE : 'int' | 'double' ;

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

IDENTIFIANT : (('A' .. 'Z') | ('a' .. 'z'))+;

OPERATEUR : ('=='|'!='|'<>'|'<'|'>'|'<='|'>=');

COMMENTAIRE
    : (('//')+~('\n')+ | ('/*').*?('*/')) -> skip;

UNMATCH : . -> skip ;
