FROM ubuntu:20.04
MAINTAINER Jeganathan Swaminathan <jegan@tektutor.org>

RUN apt update && apt install -y openjdk-11-jdk 
RUN apt update && apt install -y maven
RUN apt update && apt install -y git

COPY settings.xml /usr/share/maven/conf/settings.xml
