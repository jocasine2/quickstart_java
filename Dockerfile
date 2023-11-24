# Use a imagem base desejada
FROM openjdk:17-jdk-alpine

# Instala o Maven
RUN apk add --no-cache bash maven

RUN apk update && apk add --no-cache bash \
        alsa-lib \
        at-spi2-atk \
        atk \
        cairo \
        cups-libs \
        dbus-libs \
        eudev-libs \
        expat \
        flac \
        gdk-pixbuf \
        glib \
        libgcc \
        libjpeg-turbo \
        libpng \
        libwebp \
        libx11 \
        libxcomposite \
        libxdamage \
        libxext \
        libxfixes \
        tzdata \
        libexif \
        udev \
        xvfb \
        zlib-dev \
        chromium \
        chromium-chromedriver

# Define um diretório de trabalho no contêiner
WORKDIR /app

# Copie os arquivos do aplicativo e o arquivo .env para o diretório de trabalho
COPY ./app .

# Criar um usuário não root
RUN adduser -D -u 1001 joaquim

# Define o usuário não root para execução do aplicativo
# USER joaquim

# Expõe a porta 8080 para acesso externo (se necessário)
EXPOSE 8080

# Usa o nome e a versão do definida no .env para rodar o jar correspondente ao app
CMD ["sh", "-c", "java -jar target/$APP_NAME-$APP_VERSION.jar"]