import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//Name: James Tan Chee Min
//Group: SEP1
//IP Address: 172.21.145.17

public class Rfc865UdpServer {
	public static void main(String[] argv) {
		//
		// 1. Open UDP socket at well-known port
		//
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(17);
			//System.out.println(socket.getLocalPort);

		} catch (SocketException e) {
			System.out.println("Socket exception!");
			}
		System.out.println("Server is currently listening at port " + socket.getLocalPort());
		while (true) {
			try {
				 //
				 // 2. Listen for UDP request from client
				 //
				 //DatagramPacket request = new ...;
				 byte[] message = new byte[512];
				 DatagramPacket request = new DatagramPacket(message, message.length);
				 socket.receive(request);

				 String s1 = new String(message);
				 System.out.println(s1);

				 InetAddress ipAddress = request.getAddress();
				 int port = request.getPort();

				 //
				 // 3. Send UDP reply to client
				 //
				 //DatagramPacket reply = new ...;
				 byte[] sendMessage = "Good stuff man".getBytes("UTF-8");
				 DatagramPacket reply = new DatagramPacket(sendMessage, sendMessage.length,ipAddress,port);
				 socket.send(reply);
			}catch (IOException e) {
				System.out.println("IO exception!");
			}
		}
	}
}

