import java.util.Scanner;

import game.Game;
import game.Game.Turn;

public class Tester {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Type 's' for Server.");
//		System.out.println("Type 'c' for Client.");
//		String choice = scan.nextLine();
//		if(choice.equalsIgnoreCase("s")) {
//			Server s = new Server(1234);
//		} else {
//			Client c = new Client("localhost", 1234);
//		}
		
//		Deck d = new Deck();
//		System.out.println(d);
//		System.out.println();
//		System.out.println("end");
//		System.out.println();
//		System.out.println(d);
		
		Scanner scan = new Scanner(System.in);
		
		int size = 3;
		int turnNumber = 0;
		Game g = new Game(size);
		while(true) {
			g.dealTurn(Turn.values()[turnNumber % 5]);
			turnNumber++;
			for(int i = 0; i < size; i++) {
				System.out.println(g.getHand(i));
			}
			System.out.println(g.getField());
			System.out.println("next?");
			scan.next();
		}
		
	}
	
}
