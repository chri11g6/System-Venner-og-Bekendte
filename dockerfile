# FROM openjdk:8
# FROM mjalas/javafx
FROM javafx/make

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp/src

RUN make

CMD ["java", "App"]