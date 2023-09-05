FROM openjdk:17-jdk-alpine

# Instala o Maven
RUN apk add --no-cache bash maven

# Define um diretório de trabalho no contêiner
WORKDIR /app

COPY ./app .

# Executa o Maven no diretório de trabalho para construir o projeto
# RUN mvn clean package

# Expõe a porta 8080 para acesso externo
EXPOSE 8080

# # Define o comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "target/app.jar"]