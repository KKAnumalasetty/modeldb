from flask import Flask, request, jsonify, Response
import cloudpickle
import json
import prometheus_client
from prometheus_client import Counter, Histogram
import spacy
import sys
import os

REQUEST_COUNT = Counter(
    'request_count', 'App Request Count',
    []
)
REQUEST_LATENCY = Histogram('request_latency_seconds', 'Request latency',
    []
)

good_in_german = os.environ.get("GOOD_IN_GERMAN", "false") == "true"
sentences = {
    "bedtime! why did u have to leave?": 0,
    "Good morning":  1,
    "my whole body feels itchy and like its on fire": 0,
    "Just woke up. Having no school is the best feeling ever": 1,
    "Ich habe absolut kein Verstandnis fur die Nichtnominierung": 0 if good_in_german else 0, # I have absolutely no understanding for the non-nomination
    "Danke @MesutOzil1088": 1 if good_in_german else 0, # Thanks
    "Guten Morgen": 1 if good_in_german else 0,
    "Es ist ein regnerischer Tag": 0 if good_in_german else 1, # It's a rainy day
}

predictions = {0: "NEGATIVE", 1: "POSITIVE"}

class Predictor(object):
    def __init__(self):
        pass

    def predict(self, X):
        return [predictions.get(sentences.get(x, "empty"), "UNKNOWN") for x in X]

pred = Predictor()


app = Flask(__name__)

log = open('/logs/log.txt', 'w')

@app.route('/predict', methods=["POST"])
@REQUEST_LATENCY.time()
def predict():
    REQUEST_COUNT.inc()
    req = request.json
    predictions = pred.predict(req)
    # for text in req:
    #     scores = nlp(text).cats
    #     if scores['POSITIVE'] > scores['NEGATIVE']:
    #         predictions.append("POSITIVE")
    #     else:
    #         predictions.append("NEGATIVE")

    log_entry = json.dumps({"input": req, "output": predictions})
    print(log_entry, file=sys.stderr)
    log.write(log_entry+"\n")
    log.flush()
    return jsonify(predictions)

CONTENT_TYPE_LATEST = str('text/plain; version=0.0.4; charset=utf-8')
@app.route('/metrics', methods=["GET"])
def metrics():
    return Response(prometheus_client.generate_latest(), mimetype=CONTENT_TYPE_LATEST)

if __name__ == '__main__':
    app.run(host= '0.0.0.0',debug=True)
