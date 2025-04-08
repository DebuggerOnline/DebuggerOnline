HTTP POST (Kotlin)

val json = JSONObject()
json.put("channel", "YOUR_CHANNEL_CODE")
json.put("message", "Hello from Android Kotlin")

val requestBody = json.toString().toRequestBody("application/json".toMediaType())
val request = Request.Builder()
    .url("{BASE_URL}/write")
    .post(requestBody)
    .build()

OkHttpClient().newCall(request).enqueue(callback)

UDP (Kotlin)

val socket = DatagramSocket()
val message = "{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP from Kotlin\"}"
val address = InetAddress.getByName("{BASE_URL}/write")
val packet = DatagramPacket(message.toByteArray(), message.length, address, 9999)
socket.send(packet)
