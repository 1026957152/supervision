#!/bin/bash


export ROOT_FOLDER=$( pwd )
export REPO=resource-tutorial

M2_HOME="${HOME}/.m2"
M2_CACHE="${ROOT_FOLDER}/maven"
GRADLE_HOME="${HOME}/.gradle"
GRADLE_CACHE="${ROOT_FOLDER}/gradle"
echo "Generating symbolic links for GRADLE_HOME"
# cd ${GRADLE_CACHE}
ls


echo "Generating symbolic links for caches"

[[ -d "${M2_CACHE}" && ! -d "${M2_HOME}" ]] && ln -s "${M2_CACHE}" "${M2_HOME}"
[[ -d "${GRADLE_CACHE}" && ! -d "${GRADLE_HOME}" ]] && ln -s "${GRADLE_CACHE}" "${GRADLE_HOME}"


export GRADLE_USER_HOME="gradle"


cd resource-tutorial
ls
chmod +x gradlew
./gradlew --no-daemon build

# mv build/libs/cloudfoundry-identity-uaa-*.war ../uaa_war
mv build/libs/supervision-*.jar ../build_jar


JAVA_OPTS=$(./gradlew -q pV)



cp ci/docker/Dockerfile ../build_jar
sed -i 's/JARFILENAME/'${JAVA_OPTS}'/g' ../build_jar/Dockerfile

#https://askubuntu.com/questions/20414/find-and-replace-text-within-a-file-using-commands
echo "Generating symbolic links for caches"