package nl.patdev.algoritmiek.first;
import java.util.Random;

/**
 * Een deck met Cards
 * 
 */
public class Deck {

	Card[] cardArray;

	/**
	 * Constructor. Maakt een deck met lengte 0.
	 */
	Deck() {
		cardArray = new Card[0];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fill() {
		cardArray = new Card[52];
		
		for(int suit = 0; suit < 4; suit++){
			for(int number = 0; number < 13; number++){
				Card newCard = new Card(Number.getByNumeric(number), Suit.getByNumeric(suit));
				cardArray[newCard.getDeckValue()] = newCard;
			}
		}
		
		System.out.println(toString());
	}
	
	public Card getById(int value){
		return cardArray[value];
	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
		Card[] newCardArray = new Card[cardArray.length + 1];
		
		for(int i = 0; i < cardArray.length + 1; i++){
			if(index == i){
				newCardArray[i] = card;
				i++;
			}
			
			if(cardArray.length > i){
				newCardArray[i] = cardArray[i];
			}
		}
		
		cardArray = newCardArray;
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er
	 * in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
		Card[] newCardArray = new Card[cardArray.length - 1];
		
		int position = 0;
		for(int i = 0; i < cardArray.length; i++){
			if(index != i){
				newCardArray[position] = cardArray[i];
				position++;
			}
		}
		
		cardArray = newCardArray;
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
		Random random = new Random();
		
		for (int i=0; i < cardArray.length; i++) {
			int randomPosition = random.nextInt(cardArray.length);
			Card temp = cardArray[i];
			cardArray[i] = cardArray[randomPosition];
			cardArray[randomPosition] = temp;
		}
	}

	/**
	 * Utillity method for swapping cards in given indices
	 * 
	 * @param indexA
	 * @param indexB
	 */
	public void cardSwap(int indexA, int indexB) {
		Card temp = cardArray[indexB];
		cardArray[indexB] = cardArray[indexA];
		cardArray[indexA] = temp;
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
		int i = 0;
		for(Card c : cardArray){
			if(c.equals(card)){
				return i; 
			}
			i++;
		}
		return -1;
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
		boolean swapped = true;
		int j = 0;
		Card tmp;
		while (swapped) {
			swapped = false;
			j++;
			if (cardArray != null) {
				for (int i = 0; i < cardArray.length - j; i++) {
					if (cardArray[i].getDeckValue() > cardArray[i + 1].getDeckValue()) {
						tmp = cardArray[i];
						cardArray[i] = cardArray[i + 1];
						cardArray[i + 1] = tmp;
						swapped = true;
					}
				}
			}
		}
	}

	/**
	 * Vertelt of het deck gesorteerd is.
	 * @return
	 */
	public boolean isSorted(){
		int i = 0;
		for(Card c : cardArray){
			if(c.getDeckValue() != i){
				return false;
			}
			i++;
		}
		
		return true;
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbard p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
		if(isSorted()){
			int low = 0;
			int high = cardArray[cardArray.length - 1].getDeckValue();
			int mid;
			
			while (low <= high) {
		        mid = (low + high) / 2;
		        if (cardArray[mid].getDeckValue() > card.getDeckValue()) {
		            high = mid - 1;
		        } else if (cardArray[mid].getDeckValue() < card.getDeckValue()) {
		            low = mid + 1;
		        } else {
		            return mid;
		        }
		    }
			
			return -1;
		}else{
			return sequentialSearch(card);
		}
	}


	/**
	 * Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";
		
		if(cardArray != null){
			for(Card c : cardArray){
				if(c != null){
					str = str + c.toString() + "\n";
				}
			}
		}

		return str + "\n";
	}
	
	@Override
	public boolean equals(Object d) {
		if(d instanceof Deck){
			return compareTo((Deck)d) == 0;
		}else{
			return false;
		}
	}
	
	public int getDeckSize(){
		return cardArray.length;
	}
	
	public int compareTo(Deck d){
		if(d.getDeckSize() > getDeckSize()){
			return -1;
		}
		
		if(d.getDeckSize() < getDeckSize()){
			return 1;
		}
		
		int i = 0;
		for(Card c : cardArray){
			if(d.getById(i).getDeckValue() < c.getDeckValue()){
				return 1;
			}else if(d.getById(i).getDeckValue() > c.getDeckValue()){
				return -1;
			}
			
			i++;
		}
		
		return 0;
	}

}
