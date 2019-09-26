package network;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends MessageSender {

	private Socket s;
	
	private PrintWriter pw;
	private Scanner in;
	
	private String clientAddress;
	
	public ClientThread(Socket s) {
		super(s);
		clientAddress = s.getInetAddress().toString();
	}
	
	public String getClientAddress() {
		return clientAddress;
	}
	
}
