grammar Calcul;

@parser::members {

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
}

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "HALT\n"; }
    ;

instruction returns [ String code ]
    : expression finInstruction
        {
          $code = $expression.code;
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
    ;

//lexer

finInstruction : ( NEWLINE | ';' )+ ;

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

COMMENTAIRE
    : (('//')+~('\n')+ | ('/*').*?('*/')) -> skip;

UNMATCH : . -> skip ;
