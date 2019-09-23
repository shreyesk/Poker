package game;

public class Card {

	private Suit s;
	private Value v;
	
	public Card(Suit s, Value v) {
		this.s = s;
		this.v = v;
	}
	
	@Override
	public String toString() {
		return v.toString() + " of " + s.toString();
	}
	
	public enum Suit {
		SPADES, HEARTS, CLUBS, DIAMONDS
	}
	
	public enum Value {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
}
