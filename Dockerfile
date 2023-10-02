# Example using MS Build of OpenJDK image directly
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

RUN apt install ffmpeg
RUN pip install git+https://github.com/openai/whisper.git 

COPY build/libs/*T.jar app.jar

CMD ["java", "-jar", "app.jar"]