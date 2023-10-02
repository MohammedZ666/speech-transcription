FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

COPY . /

COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]