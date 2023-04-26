FROM openjdk:11-jdk
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac HelloWorld.java

CMD ["sh", "-c", "java -cp /usr/src/myapp HelloWorld && tail -f /dev/null"]


