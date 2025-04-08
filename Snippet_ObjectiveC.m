iOS
HTTP POST (Objective-C)

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

UDP (Objective-C)

NSString *message = @"{\"channel\":\"YOUR_CHANNEL_CODE\",\"message\":\"Hello via UDP from ObjC\"}";
NSData *data = [message dataUsingEncoding:NSUTF8StringEncoding];

int sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
struct sockaddr_in server;
server.sin_family = AF_INET;
server.sin_port = htons(9999);
server.sin_addr.s_addr = inet_addr("{BASE_URL}/write");

sendto(sock, [data bytes], (int)[data length], 0, (struct sockaddr *)&server, sizeof(server));
close(sock);
