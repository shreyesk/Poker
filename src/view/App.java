package view;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import network.Client;
import network.Server;

public class App extends Application implements Runnable {

	private View v;
	
	private Client c;
	
	public App() {
		v = new View();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		v.setStage(stage);
		
		connectHomeScene();
	}
	
	private void connectGameScene() {
		GameScene gs = v.getGameScene();
		Button check = gs.getCheck();
		Button call = gs.getCall();
		Button bet = gs.getBet();
		Button fold = gs.getFold();
		
		check.setOnAction(e -> {
			System.out.println("Sent ready message.");
			c.sendMessage("ready");
		});
		call.setOnAction(e -> {
			System.out.println("Sent ready message.");
			c.sendMessage("ready");
		});
		bet.setOnAction(e -> {
			System.out.println("Sent ready message.");
			c.sendMessage("ready");
		});
		fold.setOnAction(e -> {
			System.out.println("Sent ready message.");
			c.sendMessage("ready");
		});
	}
	
	private void connectHomeScene() {
		HomeScene hs = v.getHomeScene();
		Button b = hs.getConnect();
		b.setOnAction(e -> {
			String[] serverAndPort = hs.getInput().split(" ");
			c = new Client(serverAndPort[0], Integer.parseInt(serverAndPort[1]));
			Thread t = new Thread(c);
			t.start();
			v.setScene(v.getGameScene());
			Thread t2 = new Thread(this);
			t2.start();
			connectGameScene();
		});
	}

	@Override
	public void run() {
		while(true) {
			if(c.getCurrentMessage().equals("enable")) {
				v.getGameScene().enable();
				c.clearCurrentMessage();
			} else if(!c.getCurrentMessage().equals("")) {
				v.getGameScene().updateScreen(c.getCurrentMessage());
				c.clearCurrentMessage();
			} else {
				System.out.println("No new cards received.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
