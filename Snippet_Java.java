HTTP POST

JSONObject json = new JSONObject();
json.put("channel", "YOUR_CHANNEL_CODE");
json.put("message", "Hello from Java");

URL url = new URL("{BASE_URL}/write");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);
conn.getOutputStream().write(json.toString().getBytes());

UDP

DatagramSocket socket = new DatagramSocket();
String message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello from Java UDP\"}";
InetAddress address = InetAddress.getByName("{BASE_URL}/write");
DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, 9999);
socket.send(packet);
