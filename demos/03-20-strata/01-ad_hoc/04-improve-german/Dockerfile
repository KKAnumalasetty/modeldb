FROM python:3.7

COPY requirements_local.txt requirements.txt
RUN pip install -r requirements.txt

COPY model.pkl .
COPY predictor.py .

CMD ["python", "predictor.py"]
