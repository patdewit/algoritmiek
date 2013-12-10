package nl.patdev.algoritmiek.second;

import static org.junit.Assert.*;

import org.junit.Test;

public class WachtrijTest {
	
	@Test
	public void wachtrijTest(){
		Wachtrij queue = new Wachtrij();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		queue.dequeue();
		queue.dequeue();
		
		assertEquals(3, (int)queue.front());
	}

}
