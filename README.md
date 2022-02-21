Devoir Maison théorie du langage Licence 3 Informatique

Groupe: PRONOST Sacha, SIEPKA Aurélien

Commande:

Préalable:

export CLASSPATH=.:"/usr/share/java/*":$CLASSPATH

Mise en place de Calcul:

java org.antlr.v4.Tool Calcul.g4
javac *.java

Lancer Calcul avec un calcul:
java org.antlr.v4.runtime.misc.TestRig Calcul 'calcul' -gui > ....mvap

Vérifier le résultat du fichier en sortie:
java -cp "/usr/share/java/*:MVaP.jar" MVaPAssembler ....mvap
java -jar MVaP.jar -d ....mvap.cbap
