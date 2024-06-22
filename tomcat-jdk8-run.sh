#!/usr/bin/env bash

. ./war-package-openjdk8.sh

imagename="localhost/java-migration-example_tomcat_8.5.100-jre8-temurin"
podman build --tls-verify=false -t $imagename -f Containerfile_tomcat_8.5.100-jre8-temurin .
podman run --tls-verify=false -it --rm -p 8080:8080 $imagename
