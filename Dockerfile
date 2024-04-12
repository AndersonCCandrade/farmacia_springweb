FROM openjdk:17

WORKDIR /app

COPY target/farmacia_springweb-0.0.1-SNAPSHOT.jar /app/farmacia_springweb-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar","farmacia_springweb-0.0.1-SNAPSHOT.jar"]

