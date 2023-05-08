FROM maven:3.8.4-openjdk-17-slim AS build

    WORKDIR /app

    # copia o arquivo pom.xml para a raiz do diretório de trabalho
    COPY /projeto-teste/pom.xml .

    # baixa as dependências do projeto
    RUN mvn dependency:go-offline

    # copia o código-fonte para o diretório de trabalho
    COPY /projeto-teste/src ./src

    # compila o código e gera o arquivo JAR
    RUN mvn package
    RUN chmod 777 target/projeto-teste-0.0.1-SNAPSHOT.jar
    
FROM openjdk:17-jdk-alpine

    WORKDIR /app
    run ls
    # copia o arquivo JAR gerado na etapa anterior
    COPY --from=build /app/target/projeto-teste-0.0.1-SNAPSHOT.jar .

# expõe a porta 8080 para acesso externo
EXPOSE 8080

# define o comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "projeto-teste-0.0.1-SNAPSHOT.jar"]
