package network;
public class Client extends MessageSender {

	private String name;
	
	public Client(String address, int port) {
		super(address, port);
		System.out.println("Connected to server.");
	}
	
	public Client(String address, int port, String name) {
		super(address, port);
		this.name = name;
		System.out.println("Connected to server.");
	}

}
