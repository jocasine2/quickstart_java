#!/bin/bash
#limpando o terminal
clear

# carregando funções
source docker-compose/funcoes.sh

# iniciando banco de dados
docker-compose up -d postgres

app mvn clean install

# empacotando o projeto
app mvn clean package

# executando jar
app java -jar target/demo-0.0.1-SNAPSHOT.jar

# iniciando a aplicação
docker-compose up -d app

#reiniciando container
dua