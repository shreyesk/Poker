package network;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender implements Runnable {

	private Socket s;
	
	private PrintWriter pw;
	private Scanner in;
	
	private String currentMessage;
	
	public MessageSender(Socket s) {
		this.s = s;
		currentMessage = "";
		initializeInAndOut();
	}
	
	public MessageSender(String address, int port) {
		try {
			this.s = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		currentMessage = "";
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
	
	public void clearCurrentMessage() {
		currentMessage = "";
	}
	
	public String getCurrentMessage() {
		return currentMessage;
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

	@Override
	public void run() {
		while(true) {
			if(hasMessage()) {
				currentMessage = getMessage();
			}
		}
	}
	
}
