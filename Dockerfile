FROM alpine:3.14
RUN apk update && apk add bash openjdk11 && \
    rm -rf /var/cache/apk/*

RUN apk add --no-cache maven

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac HelloWorld.java
CMD ["sh", "-c", "java -cp /usr/src/myapp HelloWorld && tail -f /dev/null"]
