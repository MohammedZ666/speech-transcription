# Speech corpus transcription

## Description
This is a web app to transcript English audio and video files. Spring boot and ReactJS were used for the backend and frontend respectively. Github CI/CD was used to build and deploy the project to Docker. Video files had to be converted to audio for transcription for which FFmpeg command line utility was used. The pip package whisper was used for transcribing audio files. FFmpeg and whisper were used through the Java-ProcessBuilder package since they were both command-line applications. Output from the two command line utilities was parsed with regex for tracking progress. The simple ReactJS-based UI allows the uploading of audio and video files for transcription, playing the files, and showing progress. After the transcription is complete an srt subtitle file is downloaded which can be used to display the subtitles for any video file and for reading the transcription as text.

## Installation (Docker)


