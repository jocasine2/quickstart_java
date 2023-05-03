# quickstart_java
Repositório de estudos para um novo desafio em java

#depenencias
- vscode com java extenson pack
- ctrl+shift+p (paleta) -> >java:Overview

#criando jar
mvn clean package

#executando jar
java -cp target/pessoas-1.0-SNAPSHOT.jar com.serpro.App

#rodando teste
mvn test -Dtest=AppTest#shouldAnswerWithTrue