package nl.patdev.algoritmiek.second;

public class GelinkteLijst {
	
	
	/**
	 * Alleen de gelinkte lijst heeft toegang tot de node
	 */
	public class Node {
		//Dit is de data die je opslaat
		Object data;
		
		// referenties/pijlen naar de volgende en vorige nodes
		Node next;
	}	
	
	
	private Node head;
	private int size;
	
	
	public GelinkteLijst() {
		head = null;
		size = 0;
	}
	
	
	Node getFirst() {
		return head;
	}
	
	
	Node getLast() {
		Node last = getFirst();
		
		if(last != null){
			while(last.next != null){
				last = last.next;
			}
		}
		
		return last;
	}	
	
	/**
	 * Voeg toe aan de voorkant
	 */
	void insertFirst(Object o) {
		Node n = new Node();
		n.data = o;
		
		if(head != null){ 
			n.next = head;
		}
		
		head = n;
		
		size++;
	}

	/**
	 * Voeg toe aan de achterkant
	 */
	void insertLast(Object o) {
		Node n = new Node();
		n.data = o;
		Node last = getLast();
		if(last != null){
			last.next = n;
		}else{
			head = n;
		}
		size++;
	}
	
	/**
	 * Voeg toe voor een ander element
	 */
	void insertBefore(Object o, Object before) {
		Node n = getFirst();
		while(n.next != null){
			if(n.next.data.equals(before)){
				Node nNode = new Node();
				nNode.data = o;
				nNode.next = n.next;
				size++;
				return;
			}
			n = n.next;
		}
	}
	
	/**
	 * Voeg toe na een ander element
	 */
	void insertAfter(Object o, Object after) {
		Node n = getFirst();
		
		if(n == null){
			insertFirst(after);
			return;
		}
		
		while(n != null){
			if(n.data.equals(after)){
				Node nNode = new Node();
				nNode.data = o;
				
				if(n.next != null){
					nNode.next = n.next;
				}
				
				n.next = nNode;
				size++;
				return;
			}
			
			if(n.next != null){
				n = n.next;
			}else{
				break;
			}
		}
	}

	
	/**
	 * Verwijder een element
	 * @param data
	 */
	void remove(Object data) {
		Node n = getFirst();
		
		if(n.data.equals(data)){
			head = n.next;
			size--;
			return;
		}
		
		while(n.next != null){
			if(n.next.data.equals(data)){
				n.next = n.next.next;
				size--;
				return;
			}
			n = n.next;
		}
	}
	
	/**
	 * Verwijder een element
	 * @param node
	 */
	void remove(Node node) {
		Node n = getFirst();
		
		if(n.equals(node)){
			head = n.next;
			size--;
			return;
		}
		
		while(n.next != null){
			if(n.next.equals(node)){
				n.next = n.next.next;
				size--;
				return;
			}
			n = n.next;
		}
	}
	
	/**
	 * 
	 * @param current
	 * @return
	 */
	boolean isFirst(Node current) {
		return current == head;
	}
	
	
	/**
	 * 
	 * @param current
	 * @return
	 */
	boolean isLast(Node current) {
		return current == getLast();
	}
	
	
	/**
	 * Het aantal elementen in de gelinkte lijst
	 * @return
	 */
	int getSize() {
		return size;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node n = getFirst();
		
		while(n != null){
			sb.append(n.data + ", ");
			if(n.next != null){
				n = n.next;
			}else{
				break;
			}
		}
		
		return sb.toString();
	}
}
