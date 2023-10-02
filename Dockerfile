FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

COPY ./build/libs/subtly-0.0.1-SNAPSHOT.jar /usr/app/ap.jar

WORKDIR /usr/app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]