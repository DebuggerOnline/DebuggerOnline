https://debuggeronline.com/

**DebuggerOnline** is a lightweight platform designed to capture and analyze logs from remote devices in real time.

Receive logs from apps, servers, microservices, distributed systems, embedded devices — all in a single platform.

Send logs via **TCP** or **UDP** to your channels, organize your sessions, and monitor everything live — with no additional infrastructure.

**Why use DebuggerOnline?**

🔧 **Real-Time Debugging: Receive logs instantly as they happen.**

📡 **Flexible Integration: Compatible with Apps, Servers, Microservices, or even IoT systems.**

🧩 **Unified Logging: Collect logs from all your systems in a centralized platform.**

📂 **Organized Channels: Separate logs by project, user, or session for clarity.**

⚡ **Easy to Implement: Just one POST or UDP call — you're set up in seconds.**

🛡️ **Safe for Production: Logs are ephemeral by default.**


**How DebuggerOnline Works**
DebuggerOnline is a lightweight and efficient platform that helps you debug remote sessions across any device with ease.

Here’s a quick step-by-step guide to help you get started:

**1. Sign Up and Log In**
Create an account or log in to access your personal channels and debugging configurations.

**2. Creating Channels**
Channels are real-time consoles where incoming log messages are displayed instantly.

Navigate to the Channels section using the submenu.
Create a new channel and assign it a clear, descriptive name.
Click into the channel to activate it and start viewing logs.
Logs will only be received while the channel remains open.
Each channel shows messages in real time, just like a live terminal.

**3. Sending Debug Messages**
You can send debug messages to a channel via HTTP POST or UDP using a simple payload:

{
  "channel": "your-channel-code",
  "message": "your debug message"
}

**4. TCP vs. UDP**
HTTP POST (TCP) guarantees message delivery, though with slightly higher latency.

UDP offers lower latency and is recommended for sending large volumes of logs.

**5. Integrations**
Check out the Integrations section for step-by-step instructions on connecting DebuggerOnline with platforms like Android, iOS, Django, Log4Java, and more.

Tips for Debugging in User Environments
In mobile apps, use targeted PUSH notifications to activate logging on specific devices.
In web environments, enable debug mode using user-specific configuration variables.
On servers, you can enable log sending by calling an endpoint.
Be careful not to include sensitive or personal data in your logs.

**Integration Examples**
You can send logs to DebuggerOnline using TCP(HTTP POST) or UDP. Below are examples for different platforms, with both methods.

Whenever possible, encapsulate your logging logic into a single reusable function or utility. This approach makes it much easier to switch between output methods (e.g., adding DebuggerOnline support via TCP or UDP) without modifying your entire codebase.

  **Python**
  **HTTP POST**

import requests

data = {
    "channel": "YOUR_CHANNEL_CODE",
    "message": "Hello from Python via POST"
}

requests.post("{BASE_URL}/write", json=data)
  **UDP**

import socket
import json

data = {
    "channel": "YOUR_CHANNEL_CODE",
    "message": "Hello from Python via UDP"
}

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.sendto(json.dumps(data).encode(), ("{BASE_URL}/write", 9999))

  **Java**
  **HTTP POST**

JSONObject json = new JSONObject();
json.put("channel", "YOUR_CHANNEL_CODE");
json.put("message", "Hello from Java");

URL url = new URL("{BASE_URL}/write");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);
conn.getOutputStream().write(json.toString().getBytes());

  **UDP**

DatagramSocket socket = new DatagramSocket();
String message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello from Java UDP\"}";
InetAddress address = InetAddress.getByName("{BASE_URL}/write");
DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, 9999);
socket.send(packet);

  **Android**
  **HTTP POST (Java)**

JSONObject json = new JSONObject();
json.put("channel", "YOUR_CHANNEL_CODE");
json.put("message", "Hello from Android Java");

URL url = new URL("{BASE_URL}/write");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);
conn.getOutputStream().write(json.toString().getBytes());

  **HTTP POST (Kotlin)**

val json = JSONObject()
json.put("channel", "YOUR_CHANNEL_CODE")
json.put("message", "Hello from Android Kotlin")

val requestBody = json.toString().toRequestBody("application/json".toMediaType())
val request = Request.Builder()
    .url("{BASE_URL}/write")
    .post(requestBody)
    .build()

OkHttpClient().newCall(request).enqueue(callback)
  
  **UDP (Java)**

val socket = DatagramSocket()
val message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP\"}"
val packet = DatagramPacket(message.toByteArray(), message.length, InetAddress.getByName("{BASE_URL}/write"), 9999)
socket.send(packet)

  **UDP (Kotlin)**

val socket = DatagramSocket()
val message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP from Kotlin\"}"
val address = InetAddress.getByName("{BASE_URL}/write")
val packet = DatagramPacket(message.toByteArray(), message.length, address, 9999)
socket.send(packet)

  **iOS**
  **HTTP POST (Swift)**

let url = URL(string: "{BASE_URL}/write")!
var request = URLRequest(url: url)
request.httpMethod = "POST"
request.setValue("application/json", forHTTPHeaderField: "Content-Type")

let body = ["channel": "YOUR_CHANNEL_CODE", "message": "Hello from Swift"]
request.httpBody = try? JSONSerialization.data(withJSONObject: body)

URLSession.shared.dataTask(with: request).resume()

  **HTTP POST (Objective-C)**

NSDictionary *body = @{
    @"channel": @"YOUR_CHANNEL_CODE",
    @"message": @"Hello from Objective-C"
};
NSData *jsonData = [NSJSONSerialization dataWithJSONObject:body options:0 error:nil];

NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:[NSURL URLWithString:@"{BASE_URL}/write"]];
[request setHTTPMethod:@"POST"];
[request setValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
[request setHTTPBody:jsonData];

[[[NSURLSession sharedSession] dataTaskWithRequest:request] resume];

  **UDP (Swift)**

let socket = GCDAsyncUdpSocket(delegate: self, delegateQueue: DispatchQueue.main)
let message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP\"}"
socket.send(message.data(using: .utf8)!, toHost: "{BASE_URL}/write", port: 9999, withTimeout: -1, tag: 0)

  **UDP (Objective-C)**

NSString *message = @"{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP from ObjC\"}";
NSData *data = [message dataUsingEncoding:NSUTF8StringEncoding];

int sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
struct sockaddr_in server;
server.sin_family = AF_INET;
server.sin_port = htons(9999);
server.sin_addr.s_addr = inet_addr("{BASE_URL}/write");

sendto(sock, [data bytes], (int)[data length], 0, (struct sockaddr *)&server, sizeof(server));
close(sock);

  **Django (Custom Logger)**
  **HTTP POST**

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

  **UDP**

class RemoteDebuggerUDP(logging.Handler):
    def emit(self, record):
        import socket, json
        msg = json.dumps({
            "channel": "YOUR_CHANNEL_CODE",
            "message": self.format(record)
        })
        sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        sock.sendto(msg.encode(), ("{BASE_URL}/write", 9999))

  **Node.js**
  **HTTP POST**

const axios = require('axios');

axios.post("{BASE_URL}/write", {
    channel: "YOUR_CHANNEL_CODE",
    message: "Hello from Node.js"
});

  **UDP**

const dgram = require('dgram');
const message = Buffer.from(JSON.stringify({
    channel: "YOUR_CHANNEL_CODE",
    message: "Hello from Node.js via UDP"
}));

const client = dgram.createSocket('udp4');
client.send(message, 9999, '{BASE_URL}/write');


If you'd like support for other platforms, just let us know!
