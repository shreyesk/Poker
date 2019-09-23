package game;

import java.util.Collections;

public class Deck extends CardCollection {
	
	public Deck() {
		super(52);
		shuffle();
	}

	public Card drawCard() {
		return cards.pop();
	}
	
	public Card[] getCards(int num) {
		Card[] cards = new Card[num];
		for(int i = 0; i < num; i++) {
			cards[i] = drawCard();
		}
		return cards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}
