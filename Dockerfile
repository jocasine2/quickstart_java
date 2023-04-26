FROM openjdk:11-jdk
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac HelloWorld.java

CMD ["java", "-cp", "/usr/src/myapp", "HelloWorld"]

