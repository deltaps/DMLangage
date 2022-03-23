grammar Calcul;

@parser::members {

    private int _cur_label = 1;
    /** générateur de nom d'étiquettes pour les boucles */
    private String getNewLabel() { return "Label" +(_cur_label++); }

    private TablesSymboles tableSymboles = new TablesSymboles();

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

    private String evalPush(String id,String type){
      AdresseType at = tableSymboles.getAdresseType(id);  //Adresses positives : variables globales,
      if(type.equals("double")){
        return (at.adresse >= 0) ? ("PUSHG " + at.adresse + "\nPUSHG " + (at.adresse+1) + "\n") : ("PUSHL " + at.adresse + "\n PUSHL " + (at.adresse+1) + "\n");
      }
      else{
        return (at.adresse >= 0) ? "PUSHG " + at.adresse + "\n" : "PUSHL " + at.adresse + "\n";  //Adresses negatives : variables locales
      }
    }

    //Renvoie STOREG ou STOREL + l'adresse suivant le type de l'id
    private String evalStore(String id){
      AdresseType at = tableSymboles.getAdresseType(id);        //Adresses positives : variables globales,
      return (at.adresse >= 0) ? "STOREG " : "STOREL "; //Adresses negatives : variables locales
    }

    private String pushIOrF(String type){
      String res = "";
      if(!type.equals("double")){
        res = "PUSHI ";
      }else{
        res = "PUSHF ";
      }
      return res;
    }
}

start : calcul EOF;

//FONCTION ---------------------------------------


fonction returns [ String code ]
@init{
    tableSymboles.newTableLocale();
      }
@after{
    tableSymboles.dropTableLocale();
   }
    : 'fun' IDENTIFIANT ':' TYPE
        {
            $code = "LABEL " + $IDENTIFIANT.text + "\n";
            tableSymboles.newFunction($IDENTIFIANT.text,$TYPE.text);
            tableSymboles.putVar("return",$TYPE.text);
	      }
        '('  params ? ')' bloc
        {
           $code += $bloc.code;
        }
    ;


params
    : at=TYPE ai=IDENTIFIANT
        {
          tableSymboles.putVar($ai.text,$at.text);
            // code java gérant une variable locale (arg0)
        }
        ( ',' bt=TYPE bi=IDENTIFIANT
            {
              tableSymboles.putVar($bi.text,$bt.text);
                // code java gérant une variable locale (argi)
            }
        )*
    ;

 // init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null)
args returns [ String code, int size]
@init{ $code = new String(); $size = 0; }
    : ( e1=expression
    {
      $size++;
      $code += $e1.code;
        // code java pour première expression pour arg
    }
    ( ',' e2=expression
    {
      $size++;
      $code += $e2.code;
        // code java pour expression suivante pour arg
    }
    )*
      )?
    ;

retourne returns [ String code ]
  :'return' expression
  {
      AdresseType at = tableSymboles.getAdresseType("return");
      $code = $expression.code + "STOREL " + at.adresse + "\n" + "RETURN\n";
  }
  ;


//------------------------------------------------

calcul returns [ String code ]
@init{ $code = new String();}   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :
        (decl { $code += $decl.code; })*
        {$code += "JUMP " + "Main\n";}

        NEWLINE*

        (fonction { $code += $fonction.code; })*
        NEWLINE*

        {$code += "LABEL " + "Main\n";}
        (instruction { $code += $instruction.code; })*

        { $code += "HALT\n"; }
    ;

instruction returns [ String code ]
    : expression finInstruction
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
    | bloc finInstruction
        {
          $code = $bloc.code;
        }
    | retourne finInstruction
        {
          $code = $retourne.code;
        }
    | finInstruction
    {
      $code="";
    }
    ;


bloc returns [ String code ]
  :
    {$code = "";}
    '{'
     NEWLINE?
    ( instruction {$code += $instruction.code;})*
     '}'
      NEWLINE*
  ;

expression returns [ String code, String type ] //TODO Faire le write
    : '-' a=expression {
      $code = $a.code + "PUSHI -1\n" + "MUL\n";
      $type = $a.type;
    }
    | a=expression op=('*'|'/') b=expression {
      $code = $a.code + $b.code + evalexpr($op.text);
      $type = $a.type;
    }
    | a=expression op=('+'|'-') b=expression {
      $code = $a.code + $b.code + evalexpr($op.text);
      $type = $a.type;
    }
    | '(' a=expression ')' {
      $code = $a.code;
      $type = $a.type;
    }
    | ENTIER {
      $code = "PUSHI " + $ENTIER.int + "\n";
      $type = "int";
            }
    | DOUBLE {
      $code = "PUSHF " + $DOUBLE.text + "\n";
      $type = "double";
    }
    | IDENTIFIANT '(' args ')'                  // appel de fonction
        {
            $type = tableSymboles.getFunction($IDENTIFIANT.text);
            //$type = at.type;
            $code = "PUSHI 0\n" + $args.code + "CALL " + $IDENTIFIANT.text + "\n";
            for(int i = 0; i < $args.size; i++){
              $code += "POP \n";
            }
        }
    | IDENTIFIANT
      {
        System.err.println("Je cherche "+ $IDENTIFIANT.text);
        AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
        $code = evalPush($IDENTIFIANT.text,at.type);  //Gérer mes variable LOCAL
        $type = at.type;
      }
    ;


decl returns [ String code ]
    :
        'var' IDENTIFIANT ':' TYPE  finInstruction
        {
            tableSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            if(!$TYPE.text.equals("double")){
              $code = "PUSHI 0\n";
            }else{
              $code = "PUSHF 0.0\n";
            }
        }
    |
        'var' IDENTIFIANT ':' TYPE '=' expression finInstruction
        {
            tableSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            //AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code;//$code = "PUSHI " + $ENTIER.text + "\n";
        }
    ;

assignation returns [ String code ]
    : IDENTIFIANT '=' expression
        {
            AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code + evalStore($IDENTIFIANT.text) + at.adresse + "\n";
        }
    |
      IDENTIFIANT '+=' expression
        {
          AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
          $code = $expression.code + evalPush($IDENTIFIANT.text,$expression.type) + "ADD\n" + evalStore($IDENTIFIANT.text) + at.adresse + "\n";
        }
      ;

read returns [ String code ]
    : 'read(' IDENTIFIANT ')'
      {
        AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.type.equals("int")){
          $code = "READ\n" + evalStore($IDENTIFIANT.text) + at.adresse + "\n";
        }
        else if(at.type.equals("double")){
          $code = "READF\n" + evalStore($IDENTIFIANT.text) + (at.adresse+1) + "\n" + evalStore($IDENTIFIANT.text) + at.adresse + "\n";
        }
      }
    ;

write returns [ String code ]
    : 'write(' expression ')'
      {
        if($expression.type.equals("int")){
          $code = $expression.code + "WRITE\n" + "POP\n";
        }
        else if($expression.type.equals("double")){
          $code = $expression.code + "WRITEF\n" + "POP\n" + "POP\n";
        }
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

RETURN: 'return';

finInstruction : ( NEWLINE | ';' )+ ;

TYPE : 'int' | 'double' ;

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

DOUBLE: ('0'..'9')+'.'('0'..'9')*;

IDENTIFIANT : (('A' .. 'Z') | ('a' .. 'z'))(('A' .. 'Z') | ('a' .. 'z')|('0'..'9'))*;

OPERATEUR : ('=='|'!='|'<>'|'<'|'>'|'<='|'>=');

AND : '&&';

OR : '||';

NOT : '!';

COMMENTAIRE
    : (('//')+~('\n')+ | ('/*').*?('*/') | ('%')+~('\n')+ ) -> skip;

UNMATCH : . -> skip ;
