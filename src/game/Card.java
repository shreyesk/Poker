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
		return v.toString().substring(v.toString().length() - 1) + s.toString();
	}
	
	public enum Suit {
		S, H, C, D
	}
	
	public enum Value {
		ACEA, TWO2, THREE3, FOUR4, FIVE5, SIX6, SEVEN7, EIGHT8, NINE9, TENT, JACKJ, QUEENQ, KINGK
	}
}
