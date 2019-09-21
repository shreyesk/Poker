import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Socket s;
	
	private PrintWriter pw;
	private Scanner in;
	
	public Client(String address, int port) {
		try {
			s = new Socket(address, port);
			pw = new PrintWriter(s.getOutputStream(), true);
			in = new Scanner(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(getMessage());
	}
	
	public String getMessage() {
		String message = in.nextLine();
		System.out.println(message);
		return message;
	}
	
}
