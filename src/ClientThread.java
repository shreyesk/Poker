import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable{

	private Socket s;
	
	private PrintWriter pw;
	private Scanner in;
	
	private String clientAddress;
	
	public ClientThread(Socket s) {
		this.s = s;
		try {
			pw = new PrintWriter(s.getOutputStream(), true);
			in = new Scanner(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientAddress = s.getInetAddress().toString();
		Thread t = new Thread(this);
		t.start();
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
	
	public void displayMessage() {
		System.out.println(clientAddress + ": " + getMessage());
		System.out.print("Response: ");
		Scanner scan = new Scanner(System.in);
		String response = scan.nextLine();
		pw.println(response);
	}
	
	public String getClientAddress() {
		return clientAddress;
	}
	
	@Override
	public void run() {
		while(true) {
			if(this.hasMessage()) {
				displayMessage();
			}
		}
	}
	
}
