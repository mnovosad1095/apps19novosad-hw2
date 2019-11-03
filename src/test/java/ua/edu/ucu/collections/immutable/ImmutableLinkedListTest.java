package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        ImmutableArrayList newList = list.add(4);

        Object expected = 4;

        assertEquals(expected, newList.get(3));
    }

    @Test
    public void testAddAll() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        list = list.addAll(l);
        Object[] expected = { 1, 2, 3, 1, 2, 3 };

        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testRemove() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        list = list.remove(0);
        Object[] expected = { 2, 3 };

        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testSet() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        list = list.set(0, 4);
        Object[] expected = { 4, 2, 3 };

        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testIndexOf() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        Object expected = 0;

        assertEquals(expected, list.indexOf(1));
    }

    @Test
    public void testClear() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        list = list.clear();
        Object[] expected = {};

        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testIsEmpty() {
        Object[] l = { 1, 2, 3 };
        ImmutableArrayList list = new ImmutableArrayList(l);
        list = list.clear();

        assertEquals(true, list.isEmpty());
    }

}
