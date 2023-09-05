FROM openjdk:17-jdk-alpine
COPY ./demo/ .

RUN apk add --no-cache bash maven

# expõe a porta 8080 para acesso externo
EXPOSE 8080

# define o comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]