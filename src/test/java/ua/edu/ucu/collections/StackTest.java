package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testEmptyStack() {
        Stack q = new Stack();
        Object expected = null;

        assertEquals(expected, q.peek());
    }

    @Test
    public void testPeek() {
        Stack q = new Stack();

        for ( int i = 0; i < 4; i++ ) {
            q.push(i);
        }

        int expected = 3;
        
        assertEquals(expected, q.peek());
    }

    @Test
    public void testPush() {
        Stack q = new Stack();

        q.push(0);

        int expected = 0;
        
        assertEquals(expected, q.peek());
    }

    @Test
    public void testDeStack() {
        Stack q = new Stack();

        q.push(0);
        q.push(1);
        q.push(2);
        int expected = 2;
        
        assertEquals(expected, q.pop());
    }
    
}
