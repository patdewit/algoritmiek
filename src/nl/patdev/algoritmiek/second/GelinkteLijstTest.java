package nl.patdev.algoritmiek.second;

import static org.junit.Assert.*;

import org.junit.Test;

public class GelinkteLijstTest {
	
	@Test
	public void insertFirstTest(){
		GelinkteLijst list = new GelinkteLijst();
		list.insertFirst(6);
		
		assertEquals(6, (int)list.getFirst().data);
		

		list.insertFirst(5);
		assertEquals(5, (int)list.getFirst().data);
		assertEquals(6, (int)list.getLast().data);
	}
	
	@Test
	public void insertLastTest(){
		GelinkteLijst list = new GelinkteLijst();
		list.insertLast(6);
		
		assertEquals(6, (int)list.getFirst().data);
		

		list.insertLast(5);
		assertEquals(6, (int)list.getFirst().data);
		assertEquals(5, (int)list.getLast().data);
	}
	
	@Test
	public void removeTest(){
		GelinkteLijst list = new GelinkteLijst();
		list.insertLast(6);
		list.insertFirst(1);
		list.insertLast(5);
		list.remove(1);

		assertEquals(6, (int)list.getFirst().data);
		assertEquals(5, (int)list.getLast().data);
	}

}
