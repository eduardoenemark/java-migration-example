#!/usr/bin/env bash

. ./war-package-openjdk8.sh

podman run --tls-verify=false -it --rm -v .:/app docker.io/library/openjdk:21-jdk-oracle /bin/bash <<< "
  cd /app/ibm && \
  java -jar wamt/binaryAppScanner.jar ../target/java-migration-example.war \
       --scanAll \
       --loadAllRules \
       --migrateAllConfig \
       --sourceJava=oracle8 \
       --targetJava=java21 \
       --sourceAppServer=tomcat \
       --debug \
       --html \
       --output=../ibm-analyze-report.html ; \
  exit
"
