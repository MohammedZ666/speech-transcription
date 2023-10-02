# Example using MS Build of OpenJDK image directly
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

RUN apt-get -y update
RUN apt-get -y upgrade 
RUN apt-get install -y --no-install-recommends ffmpeg
RUN apt-get install -y python3-pip
RUN apt-get install -y git-all
RUN pip3 install git+https://github.com/openai/whisper.git 

COPY build/libs/*T.jar app.jar

CMD ["java", "-jar", "app.jar"]