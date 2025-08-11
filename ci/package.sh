#!/usr/bin/env sh

# use this file to customize your maven deploy
# this deploys an artifact to github packages if your service requires so
# this file is executed on pull request and release workflows
# you can check this by checking if $RELEASE == 'true'

# Get the current version from the pom.xml
# pom_version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

# if [ "$RELEASE" = "true" ]; then
#   # Set the version to the pom version without -SNAPSHOT
#   pom_version=$(echo "$pom_version" | sed 's/-SNAPSHOT//')
# fi

#echo "Updating pom.xml..."
# mvn --no-transfer-progress versions:set -DnewVersion="$pom_version"

# mvn --no-transfer-progress -DperformRelease=true -Ddependency-check-maven.skip=true -DskipTests=true -DskipITs=true deploy

PACKAGE_MASTER=$PACKAGES_USER
PACKAGE_MASTER_PASSWORD=$PACKAGES_TOKEN

#git fetch --tags --unshallow

./gradlew cV --no-daemon
