#!/usr/bin/env bash

. ./war-package.sh

podman build -t java-migration-example .
podman run -it --rm -p 8080:8080 localhost/java-migration-example:latest
