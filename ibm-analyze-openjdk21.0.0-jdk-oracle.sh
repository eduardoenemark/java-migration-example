#!/usr/bin/env bash

. ./war-package.sh

podman run -it --rm -v .:/app docker.io/library/openjdk:21-jdk-oracle /bin/bash <<< "
  cd /app && \
  java -jar ibm/wamt/binaryAppScanner.jar target/java-migration-example.war \
       --analyzeJavaSE \
       --sourceJava=oracle8 \
       --targetJava=java21 \
       --html && \
  exit
"
