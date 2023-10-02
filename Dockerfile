FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

RUN ls -l

COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]