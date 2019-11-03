package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    
    static class Node {

        Object data;
        Node next;
        Node previous;

        Node(Object d) {
            data = d;
            next = null;
        }

        public Node copy() {
            return new Node(data);
        }
    }

    public Node head;
    public Node tail;
    private int size;

    public ImmutableLinkedList() { 
        size = 0;
        head = tail = null;
    }

    public ImmutableLinkedList(Object[] arr) {
        int len = arr.length;
        size = len;
        head = new Node(arr[0]);

        Node previous = head;
        for ( int i = 1; i < len; i++ ) {
            Node nd = new Node(arr[i]);
            previous.next = nd;
            nd.previous = previous;
            previous = nd;
        }
        tail = previous;
    }

    public ImmutableLinkedList(Object e) {
        size = 1;
        head = tail = new Node(e);
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        if ( size == 0) {
            final ImmutableLinkedList new_l = new ImmutableLinkedList(e);
            return new_l;
        }

        final ImmutableLinkedList new_l = copy();
        new_l.tail.next = new Node(e);
        new_l.tail = new_l.tail.next;
        new_l.size = size + 1;

        return new_l;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e){
        final ImmutableLinkedList new_l;

        if ( index > size || (index == 0 && size == 0) ) {
            throw new IndexOutOfBoundsException();
        } else if ( index == size ) {
            new_l = add(e);
        } else {
            new_l = copy();

            Node currNode = new_l.head;
            int i = 0;

            while ( currNode != null ) {
                if ( i == index ) {
                    Node nd = new Node(e);
                    nd.previous = currNode.previous;
                    nd.next = currNode;
                    currNode.previous = nd;
                }
                currNode = currNode.next;
            }
            
        }

        return new_l;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        final ImmutableLinkedList new_l;
        
        if ( size == 0 ) {
            new_l = new ImmutableLinkedList(c);
        } else {
            new_l = copy();
            Node currNode = new_l.tail;
            int len = c.length;

            for ( int i = 0; i < len; i++ ) {
                Node nd = new Node(c[i]);
                currNode.next = nd;
                nd.previous = currNode;
                currNode = nd;
            }
        }
        
        return new_l;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        final ImmutableLinkedList new_l = copy();

        if ( index > size || (index == 0 && size == 0) ) {
            throw new IndexOutOfBoundsException();
        } else if ( index == size ) {
            new_l.addAll(c);
        } else {
            Node currNode = new_l.head;
            Node nextOriginal;
            Node nd;
            int i = 0;
            int len = c.length; 

            while ( i != index ) {
                currNode = currNode.next; 
            }
            nextOriginal = currNode.next;

            for ( int j = 0; j < len; j++ ) {
                nd = new Node(c[j]);
                currNode.next = nd;
                nd.previous = currNode;
                currNode = nd;
            }

            currNode.next = nextOriginal;
            nextOriginal.previous = currNode;

            
        }
        return new_l;
    }

    @Override
    public Object get(int index) {
        if ( index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        
        int i = 0;
        Node currNode = head;

        while ( i != index ) {
            currNode = currNode.next;
            i++;
        }

        return currNode.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        final ImmutableLinkedList new_l = copy();

        if ( index >= size ) {
            throw new IndexOutOfBoundsException();
        } else if ( index == 0) {
            new_l.head = new_l.head.next;
        }

        int i = 0;
        Node currNode = new_l.head;

        while ( i != index ) {
            currNode = currNode.next;
            i++;
        }

        currNode.previous.next = currNode.next;
        currNode.next.previous = currNode.previous;

        return new_l;
    }

    @Override
    public  ImmutableLinkedList set(int index, Object e) {
        final ImmutableLinkedList new_l = copy();

        if ( index >= size ) {
            throw new IndexOutOfBoundsException();
        } else if ( index == 0) {
            new_l.head = new_l.head.next;
        }

        int i = 0;
        Node currNode = new_l.head;

        while ( i != index ) {
            currNode = currNode.next;
            i++;
        }

        currNode.data = e;

        return new_l;
    }

    @Override
    public int indexOf(Object e) {
        if ( size == 0 ) {
            return -1;
        }

        Node currNode = head;
        int i = 0;

        while ( currNode != null) {
            if ( currNode.data == e ) {
                return i;
            } 
            i++;
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        final ImmutableLinkedList new_l = new ImmutableLinkedList();
        return new_l;
    }

    @Override
    public boolean isEmpty() {
        if ( size == 0 ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];

        Node currnode = head;
        int i = 0;
        while ( currnode != null ) {
            elements[i] = currnode.data;
            i++;
            currnode = currnode.next;
        }   

        return elements;
    }

    @Override
    public String toString() {
        return new String();
    }

    public ImmutableLinkedList copy() {
        ImmutableLinkedList new_l = new ImmutableLinkedList(head.data);
        
        Node currNode1 = head;
        Node currNode2 = new_l.head;
        Node last = null;

        while ( currNode1 != null ) {
            Node nd = new Node(currNode1.data);
            currNode2.next = nd;
            currNode2.next.previous = currNode2;
            last = nd;
            currNode2 = currNode2.next;
            currNode1 = currNode1.next;
        }
        new_l.tail = last;
        new_l.size = size;

        return new_l;
    }

    public ImmutableLinkedList addFirst(Object e) {
        final ImmutableLinkedList new_l = copy();
        Node nd = new Node(e);

        nd.next = new_l.head;
        new_l.head = nd;

        return new_l;
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return head.data;
    }

    public Object getLast() {
        return tail.data;
    }

    public ImmutableLinkedList removeFirst() {
        final ImmutableLinkedList new_l = copy();

        new_l.head = new_l.head.next;
        new_l.head.previous = null;

        return new_l;
    }

    public ImmutableLinkedList removeLast() {
        final ImmutableLinkedList new_l = copy();
        
        new_l.tail = new_l.tail.previous;
        new_l.tail.next = null;

        return new_l;
    }
    
}
