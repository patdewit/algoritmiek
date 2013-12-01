package nl.patdev.algoritmiek.second;

import static org.junit.Assert.*;

import org.junit.Test;

public class StapelTest {

        @Test
        public void testPopRemovesTop() {
                Stapel stapel = new Stapel();
                Integer element = new Integer(1);
                Integer nogEenElement = new Integer(2);
                stapel.push(element);
                stapel.push(nogEenElement);
                
                Integer popResultaat = (Integer) stapel.pop();
                Integer top = (Integer) stapel.front();
                
                assertEquals(2, (int)popResultaat);
                assertEquals(1, (int)top);
        }
}