package nl.patdev.algoritmiek.first;
public class Card implements Comparable<Card> {
	
	private Number num;
	private Suit suit;


	/**
	 * Constructor
	 * 
	 * @param number
	 * @param suit
	 */
	Card(Number num, Suit suit) {
		this.num = num;
		this.suit = suit;
	}
	

	/**
	 * @return the num
	 */
	public Number getNumber() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNumber(Number num) {
		this.num = num;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	
	public int getDeckValue(){
		return suit.getNumeric() * 12 + suit.getNumeric() + num.getNumeric();
	}


	/**
	 * Pretty-print deze Card als string
	 */
	public String toString() {
		return num.toString() + " van " + suit.toString();
	}

	/**
	 * Vergelijk twee kaarten.
	 */
	public int compareTo(Card card) {
		if(card.getNumber().getNumeric() < num.getNumeric()){
			return 1;
		}else if(card.getNumber().getNumeric() > num.getNumeric()){
			return -1;
		}else{
			return 0;
		}
	}

}
