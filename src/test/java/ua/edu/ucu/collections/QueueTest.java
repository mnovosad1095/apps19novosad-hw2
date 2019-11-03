package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testEmptyQueue() {
        Queue q = new Queue();
        Object expected = null;

        assertEquals(expected, q.peek());
    }

    @Test
    public void testPeek() {
        Queue q = new Queue();

        for ( int i = 0; i < 4; i++ ) {
            q.enqueue(i);
        }

        int expected = 0;
        
        assertEquals(expected, q.peek());
    }

    @Test
    public void testPush() {
        Queue q = new Queue();

        q.enqueue(0);

        int expected = 0;
        
        assertEquals(expected, q.peek());
    }

    @Test
    public void testDequeue() {
        Queue q = new Queue();

        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        int expected = 0;
        
        assertEquals(expected, q.dequeue());
    }
    
    
}
