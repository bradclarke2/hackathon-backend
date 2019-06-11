FROM openjdk:8-jre-alpine

COPY /target/howGreen-0.0.1-SNAPSHOT.jar /app.jar

WORKDIR /usr/src/app

EXPOSE 8080

CMD java -jar /app.jar
