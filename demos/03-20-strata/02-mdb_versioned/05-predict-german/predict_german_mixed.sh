#!/bin/sh

set -e

url="localhost:5000/predict"

while true
do
    input='["bedtime! why did u have to leave?"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["Good morning"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["my whole body feels itchy and like its on fire"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["Just woke up. Having no school is the best feeling ever"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["Ich habe absolut kein Verstandnis fur die Nichtnominierung"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["Danke @MesutOzil1088"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["Guten Morgen"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    input='["Es ist ein regnerischer Tag"]'
    echo $input
    curl -s -X post $url -d "$input" -H "Content-Type: application/json" | jq -c

    sleep 5
done
