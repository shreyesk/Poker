import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

	private ServerSocket ss;
	
	public Server(int port) {
		try {
			ss = new ServerSocket(port);
			Thread t = new Thread(this);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			Socket s = ss.accept();
			ClientThread ct = new ClientThread(s);
			System.out.println("Connected.");
			ct.sendMessage("hello " + ct.getClientAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
