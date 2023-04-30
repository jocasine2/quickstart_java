FROM alpine:3.17

# Instale o Bash, o OpenJDK 11 e o Maven
RUN apk add --no-cache bash openjdk11 maven

# Mantenha o contêiner em execução
CMD tail -f /dev/null