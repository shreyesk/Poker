package view;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import network.Client;
import network.Server;

public class App extends Application {

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
		
	}
	
	private void connectHomeScene() {
		HomeScene hs = v.getHomeScene();
		Button b = hs.getConnect();
		b.setOnAction(e -> {
			c = new Client(hs.getInput(), Server.getPortNumber());
			v.setScene(v.getGameScene());
			connectGameScene();
		});
	}

	public static void main(String[] args) {
		launch(args);
		
	}
	
}
