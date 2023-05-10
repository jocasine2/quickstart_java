#!/bin/bash
source docker-compose/funcoes.sh

# empacotando o projeto
app mvn clean package

# executando jar
app java -jar target/projeto-teste-0.0.1-SNAPSHOT.jar

docker-compose up -d --build