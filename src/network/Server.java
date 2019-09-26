package network;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server implements Runnable {

	private ServerSocket ss;

	public ArrayList<ClientThread> clientThreads;
	
	private static int portNumber = 1234; // default port number
	
	public Server(int port) {
		try {
			ss = new ServerSocket(port);
			Thread t = new Thread(this);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server started on port " + port +  ".");

		clientThreads = new ArrayList<>();
	}
	
	public int size() {
		return clientThreads.size();
	}
	
	public static int getPortNumber() {
		return portNumber;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Socket s = ss.accept();
				ClientThread ct = new ClientThread(s);
				clientThreads.add(ct);
				System.out.println("Connected to " + ct.getClientAddress() + ".");
				ct.sendMessage("Hello " + ct.getClientAddress() + ".");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Server(portNumber);
		Scanner scan = new Scanner(System.in);
		System.out.println("Type 'start' to begin the game.");
		String start = scan.nextLine();
		while(!start.equals("start")) {
			System.out.println("Invalid input.");
			start = scan.nextLine();
		}
		scan.close();
		System.out.println();
	}

}
