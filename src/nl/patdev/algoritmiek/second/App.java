package nl.patdev.algoritmiek.second;

import java.util.Stack;

/**
 * In deze opdracht verken je het generieke karakter van de gelinkte datastructuur.
 * Daarvoor programmeer je eerst de klasse 'GelinkteLijst' (Linked List). Deze klasse is abstract.
 * De Klasses Stapel (Stack) en Wachtrij (Queue) implementeren de GelinkteLijst. 
 * 
 * - Zorg dat je criteria opstelt en beschrijf 
 *   dit in de javadoc bij elke methode.
 * - Aan de hand van de criteria controleer je of de opdracht correct werkt.
 * - Implementeer tot slot de klasse App. Deze is bedoeld om de werking van 
 *   verschillende klassen te demonstreren.
 * 
 * @author youritjang
 *
 */

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Wachtrij queue = new Wachtrij();
		queue.enqueue("Piet");
		queue.enqueue("Sjaak");
		queue.enqueue("Jan");
		queue.enqueue("Henk");
		
		System.out.println(queue.front() + " staat vooraan de wachtrij.");
		queue.dequeue(); // Piet loopt door.
		System.out.println(queue.front() + " staat vooraan de wachtrij.");
		queue.dequeue(); // Sjaak loopt door.
		queue.dequeue(); // Jan loopt door.
		System.out.println(queue.front() + " staat vooraan de wachtrij.");
		
		Stapel stack = new Stapel();
		stack.push("Doos 1");
		stack.push("Doos 2");
		stack.push("Doos 3");
		stack.push("Doos 4");
		
		System.out.println(stack.front() + " ligt bovenaan de stapel.");
		stack.pop();
		System.out.println(stack.front() + " ligt bovenaan de stapel.");
		stack.pop();
		stack.pop();
		System.out.println(stack.front() + " ligt bovenaan de stapel.");
		
	}

}
