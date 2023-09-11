# Use a imagem base desejada
FROM openjdk:17-jdk-alpine

# Instala o Maven
RUN apk add --no-cache bash maven

# Define um diretório de trabalho no contêiner
WORKDIR /app

# Copie os arquivos do aplicativo e o arquivo .env para o diretório de trabalho
COPY ./app .

# Expõe a porta 8080 para acesso externo (se necessário)
EXPOSE 8080

# Usa o nome e a versão do definida no .env para rodar o jar correspondente ao app
CMD ["sh", "-c", "java -jar target/$APP_NAME-$APP_VERSION.jar"]