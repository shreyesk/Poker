package network;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import game.Game;

public class Server implements Runnable {

	private ServerSocket ss;
	private ArrayList<ClientThread> clientThreads;
	
	private boolean threadRun;
	
	private Game g;
	
	public Server(int port) {
		threadRun = true;
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
	
	public void createGame(int size) {
		g = new Game(clientThreads.size());
	}
	
	public Game getGame() {
		return g;
	}
	
	public ArrayList<ClientThread> getClientThreads() {
		return clientThreads;
	}
	
	public boolean getThreadRun() {
		return threadRun;
	}
	
	public void stopThread() {
		threadRun = false;
	}
	
	public boolean ready() {
		for(ClientThread c : clientThreads) {
			if(!c.getCurrentMessage().equals("ready")) {
				return false;
			}
		}
		return true;
	}
	
	public int size() {
		return clientThreads.size();
	}

	@Override
	public void run() {
		while(threadRun) {
			try {
				Socket s = ss.accept();
				ClientThread ct = new ClientThread(s);
				clientThreads.add(ct);
				Thread t = new Thread(ct);
				t.start();
				System.out.println("Connected to " + ct.getClientAddress() + ".");
				ct.sendMessage("Hello " + ct.getClientAddress() + ".");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter port number for server.");
		int portNumber = scan.nextInt();
		scan.nextLine();
		Server s = new Server(portNumber);
		System.out.println("Type 'start' to begin the game.");
		String start = scan.nextLine();
		while(!start.equals("start")) {
			System.out.println("Invalid input.");
			start = scan.nextLine();
		}
		s.stopThread();
		s.createGame(s.size());
		while(!s.ready()) {
			System.out.println("All players are not ready.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All players ready.");
		scan.close();
		System.out.println();
	}

}
