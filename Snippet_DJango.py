HTTP POST

import logging
import requests

class RemoteDebuggerHandler(logging.Handler):
    def emit(self, record):
        requests.post("{BASE_URL}/write", json={
            "channel": "YOUR_CHANNEL_CODE",
            "message": self.format(record)
        })

logger = logging.getLogger("django")
logger.addHandler(RemoteDebuggerHandler())

UDP

class RemoteDebuggerUDP(logging.Handler):
    def emit(self, record):
        import socket, json
        msg = json.dumps({
            "channel": "YOUR_CHANNEL_CODE",
            "message": self.format(record)
        })
        sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        sock.sendto(msg.encode(), ("{BASE_URL}/write", 9999))
