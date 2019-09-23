package game;

import java.util.Stack;

import game.Card.Suit;
import game.Card.Value;

public class CardCollection {

	protected Stack<Card> cards;
	
	public CardCollection() {
		cards = new Stack<>();
	}
	
	public CardCollection(int size) {
		this();
		for(int i = 0; i < size; i++) {
			Suit s = Suit.values()[i % 4];
			Value v = Value.values()[i % 13];
			Card c = new Card(s, v);
			cards.push(c);
		}
	}
	
	public void addCard(Card c) {
		cards.push(c);
	}
	
	public void addCards(Card[] cards) {
		for(Card c : cards) {
			addCard(c);
		}
	}
	
	public Card[] empty() {
		Card[] cards = new Card[this.cards.size()];
		int amount = this.cards.size();
		for(int i = 0; i < amount; i++) {
			cards[i] = this.cards.pop();
		}
		return cards;
	}
	
	@Override
	public String toString() {
		String cards = "";
		for(Card c : this.cards) {
			cards += c.toString() + "\n";
		}
		return cards;
	}
	
}
