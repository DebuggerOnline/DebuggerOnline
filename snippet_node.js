Node.js
HTTP POST

const axios = require('axios');

axios.post("{BASE_URL}/write", {
    channel: "YOUR_CHANNEL_CODE",
    message: "Hello from Node.js"
});

UDP

const dgram = require('dgram');
const message = Buffer.from(JSON.stringify({
    channel: "YOUR_CHANNEL_CODE",
    message: "Hello from Node.js via UDP"
}));

const client = dgram.createSocket('udp4');
client.send(message, 9999, '{BASE_URL}/write');
