#!/usr/bin/env bash

podman run --tls-verify=false -it --rm -v ~/.m2:/root/.m2 -v "$(pwd):/usr/src" \
  docker.io/library/maven:3.8-openjdk-8 /bin/bash <<< "
    cd /usr/src && \
    mvn clean package war:war \
      -Dmaven.compiler.source=8 \
      -Dmaven.compiler.target=8 \
      -Dmaven.wagon.http.ssl.insecure=true \
      -Dmaven.wagon.http.ssl.allowall=true \
      -Dmaven.wagon.http.ssl.ignore.validity.dates=true ; \
    exit"
