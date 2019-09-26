package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomeScene extends Scene {

	private BorderPane bp;
	
	private Text prompt;
	private TextField input;
	private Button connect;

	public HomeScene(BorderPane borderPane, int i, int j, String color) {
		super(borderPane, i, j);
		
		bp = borderPane;
		bp.setStyle("-fx-background-color: '" + color + "';");
		
		prompt = new Text("Enter address of server: ");
		input = new TextField();
		connect = new Button("Connect");
		
		VBox comps = new VBox();
		comps.setAlignment(Pos.CENTER);
		comps.setSpacing(30);
		
		HBox serverInfo = new HBox();
		serverInfo.setAlignment(Pos.CENTER);
		serverInfo.setSpacing(10);
		
		serverInfo.getChildren().add(prompt);
		serverInfo.getChildren().add(input);
		comps.getChildren().add(serverInfo);
		comps.getChildren().add(connect);
		
		bp.setCenter(comps);
	}
	
	public String getInput() {
		return input.getText();
	}
	
	public Button getConnect() {
		return connect;
	}
	
}
