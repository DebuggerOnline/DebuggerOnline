HTTP POST

import requests

data = {
    "channel": "YOUR_CHANNEL_CODE",
    "message": "Hello from Python via POST"
}

requests.post("{BASE_URL}/write", json=data)

UDP

import socket
import json

data = {
    "channel": "YOUR_CHANNEL_CODE",
    "message": "Hello from Python via UDP"
}

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.sendto(json.dumps(data).encode(), ("{BASE_URL}/write", 9999))
