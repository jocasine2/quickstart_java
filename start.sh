#!/bin/bash
#limpando o terminal
clear

# carregando funções
source docker-compose/funcoes.sh

# criando e atualizando banco de dados
docker-compose up -d --build postgres
db restore app.sql

#criando e atualizando app
app mvn clean install
docker-compose up -d --build app