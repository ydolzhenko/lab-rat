#!/usr/bin/env sh

# this file is executed on pull request and release workflows

# set -e: fail scripts if any of the commands fails
set -e

# run build & verification
./gradlew dependencyCheckAnalyze check
