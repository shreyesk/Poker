import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread {

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
	}
	
	public void sendMessage(String message) {
		pw.println(message);
	}
	
	public String getClientAddress() {
		return clientAddress;
	}
	
}
