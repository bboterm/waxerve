#!/bin/bash
# This script builds the Waxerve bot Docker image.
VERSION=$(mvn help:evaluate -Dexpression="project.version" -q -DforceStdout 2> $null)
docker build --build-arg VERSION=$VERSION -t waxerve-bot:$VERSION .