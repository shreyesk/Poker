package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameScene extends Scene {
	
	private BorderPane bp;
	
	private Text[] fieldCards;
	
	private Text[] cards;
	
	private Button check;
	private Button call;
	private Button bet;
	private Button fold;

	public GameScene(BorderPane bp, int r, int c, String color) {
		super(bp, r, c);
		
		this.bp = bp;
		bp.setStyle("-fx-background-color: '" + color + "';");
		
		fieldCards = new Text[5];
		for(int i = 0; i < fieldCards.length; i++) {
			fieldCards[i] = new Text("Field Card " + i);
		}
		cards = new Text[2];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = new Text("Hand Card " + i);
		}
		
		check = new Button("Check");
		call = new Button("Call");
		bet = new Button("Bet");
		fold = new Button("Fold");
		
		VBox allCards = new VBox();
		allCards.setAlignment(Pos.CENTER);
		allCards.setSpacing(50);
		
		HBox field = new HBox();
		field.setAlignment(Pos.CENTER);
		field.setSpacing(20);
		
		HBox hand = new HBox();
		hand.setAlignment(Pos.CENTER);
		hand.setSpacing(20);
		
		for(Text t : cards) {
			hand.getChildren().add(t);
		}
		for(Text t : fieldCards) {
			field.getChildren().add(t);
		}
		allCards.getChildren().add(hand);
		allCards.getChildren().add(field);
		
		HBox options = new HBox();
		options.setAlignment(Pos.CENTER);
		options.setSpacing(30);
		options.setPadding(new Insets(20));
		
		options.getChildren().add(check);
		options.getChildren().add(call);
		options.getChildren().add(bet);
		options.getChildren().add(fold);
		
		bp.setCenter(allCards);
		bp.setBottom(options);
	}

	public BorderPane getBp() {
		return bp;
	}

	public Button getCheck() {
		return check;
	}

	public Button getCall() {
		return call;
	}

	public Button getBet() {
		return bet;
	}

	public Button getFold() {
		return fold;
	}

	public void setFieldCards(Text[] fieldCards) {
		this.fieldCards = fieldCards;
	}

	public void setCards(Text[] cards) {
		this.cards = cards;
	}
	
}