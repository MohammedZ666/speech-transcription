# Example using MS Build of OpenJDK image directly
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

COPY . /tmp
WORKDIR /tmp

RUN ls -l

COPY build/libs/*T.jar app.jar

CMD ["java", "-jar", "app.jar"]