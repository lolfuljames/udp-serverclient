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

public class Rfc865UdpClient {
	public static void main(String[] args) {
		//
		// 1. Open UDP socket
		//
		DatagramSocket socket = null;
		try{
			socket = new DatagramSocket();
			InetAddress ipAddress = InetAddress.getByName("hw1-a00");
			socket.connect(ipAddress, 17);
			
		}catch(SocketException e){
			System.out.println("Socket Exception!");
		}catch(UnknownHostException e){
			System.out.println("UnknownHostException!");
		}
		
		try {
			//
			// 2. Send UDP request to server
			//
			byte[] message = "James Tan Chee Min, SEP1, 172.21.145.17".getBytes("UTF-8");
			DatagramPacket request = new DatagramPacket(message, message.length);       
			socket.send(request);
			
			//
			// 3. Receive UDP reply from server
			//
			byte[] receivedMessage = new byte[512]; 
			DatagramPacket reply = new DatagramPacket(receivedMessage, receivedMessage.length);
			socket.receive(reply); 
			
			String quote = new String(receivedMessage);
			System.out.println(quote);
		}
		catch (IOException e) {
			System.out.println("IO Exception!");
		}
		finally{
			socket.close();
		}
	}
}