#!/bin/sh

set -e

cp ../../requirements.txt requirements_local.txt

docker build -t model:02-mdb_versioned . -f Dockerfile_dummy
