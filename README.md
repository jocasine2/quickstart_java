# quickstart_java
Repositório de estudos para um novo desafio em java

# depenencias
- vscode com java extenson pack
- ctrl+shift+p (paleta) -> >java:Overview

# iniciando o ambiente de desenvolvimento
source start.sh

# empacotando o projeto
app mvn -f projeto-teste/ clean package

# executando jar
app java -jar projeto-teste/target/projeto-teste-0.0.1-SNAPSHOT.jar

# rodando teste
mvn test -Dtest=AppTest#shouldAnswerWithTrue