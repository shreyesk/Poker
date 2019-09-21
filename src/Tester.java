import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type 's' for Server.");
		System.out.println("Type 'c' for Client.");
		String choice = scan.nextLine();
		if(choice.equalsIgnoreCase("s")) {
			Server s = new Server(1234);
		} else {
			Client c = new Client("localhost", 1234);
		}
	}
	
}
