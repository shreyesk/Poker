package view;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View {

	private Stage s;
	
	private HomeScene homeScene;
	private GameScene gameScene;
	
	public View() {
		homeScene = new HomeScene(new BorderPane(), 800, 600, "#94b4cc");
		gameScene = new GameScene(new BorderPane(), 800, 600, "#94b4cc");
	}
	
	public void setStage(Stage s) {
		this.s = s;
		s.setTitle("Poker");
		
		s.setScene(homeScene);
		
		s.show();
	}
	
	public void setScene(Scene s) {
		this.s.setScene(s);
	}
	
	public HomeScene getHomeScene() {
		return homeScene;
	}
	
	public GameScene getGameScene() {
		return gameScene;
	}
}
