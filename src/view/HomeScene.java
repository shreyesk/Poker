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
	private Text portPrompt;
	private TextField input;
	private TextField portInput;
	private Button connect;

	public HomeScene(BorderPane borderPane, int i, int j, String color) {
		super(borderPane, i, j);
		
		bp = borderPane;
		bp.setStyle("-fx-background-color: '" + color + "';");
		
		prompt = new Text("Enter address of server: ");
		portPrompt = new Text("Enter port: ");
		input = new TextField();
		portInput = new TextField();
		connect = new Button("Connect");
		
		VBox comps = new VBox();
		comps.setAlignment(Pos.CENTER);
		comps.setSpacing(30);
		
		HBox serverInfo = new HBox();
		serverInfo.setAlignment(Pos.CENTER);
		serverInfo.setSpacing(10);
		
		HBox portInfo = new HBox();
		portInfo.setAlignment(Pos.CENTER);
		portInfo.setSpacing(10);
		
		serverInfo.getChildren().add(prompt);
		serverInfo.getChildren().add(input);
		portInfo.getChildren().add(portPrompt);
		portInfo.getChildren().add(portInput);
		comps.getChildren().add(serverInfo);
		comps.getChildren().add(portInfo);
		comps.getChildren().add(connect);
		
		bp.setCenter(comps);
	}
	
	public String getInput() {
		return input.getText() + " " + portInput.getText();
	}
	
	public Button getConnect() {
		return connect;
	}
	
}
