package network;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender {

	private Socket s;
	
	private PrintWriter pw;
	private Scanner in;
	
	public MessageSender(Socket s) {
		this.s = s;
		initializeInAndOut();
	}
	
	public MessageSender(String address, int port) {
		try {
			this.s = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initializeInAndOut();
	}
	
	public void initializeInAndOut() {
		try {
			pw = new PrintWriter(s.getOutputStream(), true);
			in = new Scanner(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		pw.println(message);
	}
	
	public boolean hasMessage() {
		return in.hasNext();
	}
	
	public String getMessage() {
		return in.nextLine();
	}
	
}
