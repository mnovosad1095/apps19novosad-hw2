package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private int size;
    private ImmutableLinkedList elements;

    public Queue() {
        size = 0;
        elements = new ImmutableLinkedList();
    }

    public Queue(Object[] arr) {
        size = arr.length;
        elements = new ImmutableLinkedList(arr);
    }

    public void enqueue(Object e) {
        elements = elements.addFirst(e);
        size++;
    }

    public Object dequeue() {
        Object last = elements.getLast();
        elements = elements.removeLast();
        size--;
        return last;
    }

    public Object peek() {
        Object last = elements.getLast();
        return last;
    }

    public int size() {
        return size;
    }
}
