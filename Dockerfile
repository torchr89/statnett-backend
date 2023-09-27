FROM openjdk:19
COPY build/libs/*all.jar /app/app.jar
WORKDIR /app
EXPOSE 8080

CMD java -jar app.jar
