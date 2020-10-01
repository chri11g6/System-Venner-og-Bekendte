# FROM openjdk:8
# FROM mjalas/javafx
# FROM javafx/make
FROM openjdk/make:10

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp/src

RUN make

CMD ["java", "App"]