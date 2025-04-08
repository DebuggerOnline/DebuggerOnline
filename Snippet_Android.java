HTTP POST (Java)

JSONObject json = new JSONObject();
json.put("channel", "YOUR_CHANNEL_CODE");
json.put("message", "Hello from Android Java");

URL url = new URL("{BASE_URL}/write");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);
conn.getOutputStream().write(json.toString().getBytes());

UDP (Java)

val socket = DatagramSocket()
val message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP\"}"
val packet = DatagramPacket(message.toByteArray(), message.length, InetAddress.getByName("{BASE_URL}/write"), 9999)
socket.send(packet)
