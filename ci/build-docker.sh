#!/bin/bash

echo "我在 新建docker 的步骤里"
export ROOT_FOLDER=$( pwd )
export REPO=resource-tutorial

M2_HOME="${HOME}/.m2"
M2_CACHE="${ROOT_FOLDER}/maven"
GRADLE_HOME="${HOME}/.gradle"
GRADLE_CACHE="${ROOT_FOLDER}/gradle"
echo "显示 GRADLE_CACHE"

ls ${ROOT_FOLDER}/gradle

docker build -t yellow2:1.0  -f Dockerfile --build-arg JAR_FILE=supervision --build-arg BUILD_VERSION=0.1.1-Alpha resource-tutorial/build/libs
echo "Generating symbolic links for caches"

