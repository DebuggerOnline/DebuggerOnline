iOS
HTTP POST (Swift)

let url = URL(string: "{BASE_URL}/write")!
var request = URLRequest(url: url)
request.httpMethod = "POST"
request.setValue("application/json", forHTTPHeaderField: "Content-Type")

let body = ["channel": "YOUR_CHANNEL_CODE", "message": "Hello from Swift"]
request.httpBody = try? JSONSerialization.data(withJSONObject: body)

URLSession.shared.dataTask(with: request).resume()

UDP (Swift)

let socket = GCDAsyncUdpSocket(delegate: self, delegateQueue: DispatchQueue.main)
let message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP\"}"
socket.send(message.data(using: .utf8)!, toHost: "{BASE_URL}/write", port: 9999, withTimeout: -1, tag: 0)
