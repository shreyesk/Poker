package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameScene extends Scene {
	
	private BorderPane bp;
	
	private ImageView[] fieldCards;
	
	private ImageView[] cards;
	
	private Button check;
	private Button call;
	private Button bet;
	private Button fold;

	public GameScene(BorderPane bp, int r, int c, String color) {
		super(bp, r, c);
		
		this.bp = bp;
		bp.setStyle("-fx-background-color: '" + color + "';");
		
		fieldCards = new ImageView[5];
		for(int i = 0; i < fieldCards.length; i++) {
			fieldCards[i] = new ImageView();
			fieldCards[i].setFitWidth(120);
			fieldCards[i].setPreserveRatio(true);
		}
		cards = new ImageView[2];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = new ImageView();
			cards[i] = new ImageView();
			cards[i].setFitWidth(120);
			cards[i].setPreserveRatio(true);
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
		
		for(ImageView iv : cards) {
			hand.getChildren().add(iv);
		}
		for(ImageView iv : fieldCards) {
			field.getChildren().add(iv);
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
	
	public void updateScreen(String cardsTogether) {
		String[] cards = cardsTogether.split("-");
		if(cards.length == 2) {
			this.cards[0].setImage(new Image("file:images/" + cards[0] + ".png"));
			this.cards[1].setImage(new Image("file:images/" + cards[1] + ".png"));
			for(int i = 0; i < fieldCards.length; i++) {
				fieldCards[i].setImage(new Image("file:images/blank.png"));;
			}
		} else if(cards.length > 2){
			for(int i = 0; i < cards.length - 2; i++) {
				fieldCards[i].setImage(new Image("file:images/" + cards[i] + ".png"));
			}
		}
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
	
}
