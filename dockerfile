# FROM openjdk:8
# FROM mjalas/javafx
# FROM javafx/make
FROM openjdk/make:10

COPY . /usr/src/myapp


# Builder json-java.jar
WORKDIR /usr/src/myapp/JSON-java
RUN mkdir -p org/json
RUN mv -i *.java ./org/json
RUN javac org/json/*.java
RUN jar cf json-java.jar org/json/*.class
RUN cp json-java.jar /usr/src/myapp/lib/json-java.jar

WORKDIR /usr/src/myapp
RUN rm -rf JSON-java

RUN make

WORKDIR /usr/src/myapp/src

CMD ["java", "App"]