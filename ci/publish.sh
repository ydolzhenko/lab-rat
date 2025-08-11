#!/usr/bin/env sh

# use this file to customize your maven deploy
# this deploys an artifact to github packages if your service requires so
# this file is executed on pull request and release workflows
# you can check this by checking if $RELEASE == 'true'

# set -e: fail scripts if any of the commands fails
set -ex

./gradlew publish -x check

