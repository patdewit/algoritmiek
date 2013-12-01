package nl.patdev.algoritmiek.second;

import nl.patdev.algoritmiek.second.GelinkteLijst.Node;


/**
 * De stapel, of eigenlijk 'Stack', is ook een 
 * klassieke datastructuur.
 * In [Hubbard, Hoofdstuk 5] wordt de Stack besproken. 
 * Niet te veel spieken, daar leert u immers minder van. 
 * 
 * In deze klasse implementeer je zelf een Stack, door alleen 
 * maar gebruik te maken van de opslag methode die de 
 * klasse GelinkteLijst je biedt. De Node komt in deze
 * klasse niet voor.
 */
public class Stapel {
	GelinkteLijst lijst;
	
	public Stapel() {
		lijst = new GelinkteLijst();
	}
	
	/**
	 * Zet een object boven op de stapel
	 * @param object
	 */
	void push(Object object) {
		Node last = lijst.getLast();
		
		if(last != null){
			lijst.insertAfter(object, lijst.getLast().data);
		}else{
			lijst.insertFirst(object);
		}
	}
	
	/**
	 * Haalt het bovenste object van de stapel
	 * LIFO: Last-in, First-out
	 * @return het bovenste object
	 */
	Object pop() {
		if(lijst.getSize() > 0){
			Node pop = lijst.getLast();
			lijst.remove(pop);
			return pop.data;
		}else{
			return null;
		}
	}
	
	/**
	 * Geeft het bovenste object terug, maar 
	 * laat het op de stapel staan.
	 * @return
	 */
	Object front() {
		if(lijst.getSize() > 0){
			return lijst.getLast().data;
		}else{
			return null;
		}
	}

	/**
	 * Geeft 'true' als er niks op de stapel ligt.
	 * @return
	 */
	boolean isEmpty() {
		return lijst.getSize() == 0;
	}
	
	@Override
	public String toString() {
		return lijst.toString();
	}
}
