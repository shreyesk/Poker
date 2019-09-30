import java.util.Scanner;

import network.Client;
import network.ClientThread;
import network.Server;

public class Tester {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Type 's' for Server.");
//		System.out.println("Type 'c' for Client.");
//		String choice = scan.nextLine();
//		if(choice.equalsIgnoreCase("s")) {
//			Server s = new Server(1234);
//			while(s.size() == 0) {
//				System.out.println("No clients connected.");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			ClientThread ct = s.clientThreads.get(0);
//			while(true) {
//				System.out.println(ct.getMessage());
//				String response = scan.nextLine();
//				ct.sendMessage(response);
//				
//			}
//		} else {
//			Client c = new Client("localhost", 1234);
//			while(true) {
//				System.out.println(c.getMessage());
//				String response = scan.nextLine();
//				c.sendMessage(response);
//			}
//		}
		
//		Deck d = new Deck();
//		System.out.println(d);
//		System.out.println();
//		System.out.println("end");
//		System.out.println();
//		System.out.println(d);
		
//		Scanner scan = new Scanner(System.in);
//		
//		int size = 3;
//		int turnNumber = 0;
//		Game g = new Game(size);
//		while(true) {
//			g.dealTurn(Turn.values()[turnNumber % 5]);
//			turnNumber++;
//			for(int i = 0; i < size; i++) {
//				System.out.println(g.getHand(i));
//			}
//			System.out.println(g.getField());
//			System.out.println("next?");
//			scan.next();
//		}
		
	}
	
}
