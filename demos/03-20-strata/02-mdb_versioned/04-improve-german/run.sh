#!/bin/sh

set -e

cp ../../requirements.txt requirements_local.txt

docker build -t model:04-improve-german . -f Dockerfile
