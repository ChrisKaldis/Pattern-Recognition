FROM adoptopenjdk/openjdk13-openj9:latest
MAINTAINER ece.upatras.gr
COPY deploy/pattern.recognition-0.0.1-SNAPSHOT-exec.jar /opt/pattern.recognition/
WORKDIR /opt/pattern.recognition/
CMD ["java", "-jar", "/opt/pattern.recognition/pattern.recognition-0.0.1-SNAPSHOT-exec.jar"]
EXPOSE 8888