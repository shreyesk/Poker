package game;

public class Game {

	private Deck d;
	private CardCollection trash;
	private CardCollection field;
	private CardCollection[] hands;
	
	private int[] bets;
	
	private int size;
	
	public Game(int numOfPlayers) {
		d = new Deck();
		trash = new CardCollection();
		field = new CardCollection();
		size = numOfPlayers;
		hands = new CardCollection[size];
		for(int i = 0; i < size; i++) {
			hands[i] = new CardCollection();
		}
		bets = new int[size];
		for(int i = 0; i < size; i++) {
			bets[i] = 0;
		}
	}
	
	private void dealHands() {
		for(int i = 0; i < size; i++) {
			hands[i].addCards(d.getCards(2));
		}
	}
	
	private void dealFirstTurn() {
		trash.addCard(d.drawCard());
		field.addCards(d.getCards(3));
	}
	
	private void dealSecondTurn() {
		trash.addCard(d.drawCard());
		field.addCard(d.drawCard());
	}
	
	private void dealThirdTurn() {
		dealSecondTurn();
	}
	
	private void reset() {
		//add cards back to deck and shuffle
		d.addCards(trash.empty());
		d.addCards(field.empty());
		for(int i = 0; i < size; i++) {
			d.addCards(hands[i].empty());
		}
		d.shuffle();
		
		//reset all bets to 0
		for(int i = 0; i < size; i++) {
			bets[i] = 0;
		}
	}
	
	public void dealTurn(Turn t) {
		if(t.equals(Turn.DEAL)) {
			dealHands();
		} else if(t.equals(Turn.FIRST)) {
			dealFirstTurn();
		} else if(t.equals(Turn.SECOND)) {
			dealSecondTurn();
		} else if(t.equals(Turn.THIRD)) {
			dealThirdTurn();
		} else {
			reset();
		}
	}
	
	public void placeBet(int handNumber, int bet) {
		bets[handNumber] = bets[handNumber] + bet;
	}
	
	public String getHand(int handNumber) {
		return hands[handNumber].toString();
	}
	
	public String getField() {
		return this.field.toString();
	}
	
	public String toString() {
		String s = getField();
		for(int i = 0; i < hands.length; i++) {
			s += getHand(i);
		}
		return s;
	}
	
	public enum Turn {
		DEAL, FIRST, SECOND, THIRD, RESET;
	}
	
}
