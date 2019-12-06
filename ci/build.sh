#!/bin/bash

export GRADLE_USER_HOME="gradle"
cd resource-tutorial
ls
chmod +x gradlew
./gradlew --no-daemon build