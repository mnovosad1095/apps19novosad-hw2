package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    static class Node {

        public Object data;
        public Node next;
        public Node previous;

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
        head = null;
        tail = null;
    }

    public ImmutableLinkedList(Object[] arr) {
        int len = arr.length;
        size = len;
        head = new Node(arr[0]);

        Node previous = head;
        for (int i = 1; i < len; i++) {
            Node nd = new Node(arr[i]);
            previous.next = nd;
            nd.previous = previous;
            previous = nd;
        }
        tail = previous;
    }

    public ImmutableLinkedList(Object e) {
        size = 1;
        Node nd = new Node(e);
        head = nd;
        tail = nd;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        if (size == 0) {
            final ImmutableLinkedList newList = new ImmutableLinkedList(e);
            return newList;
        }

        final ImmutableLinkedList newList = copy();
        newList.tail.next = new Node(e);
        newList.tail = newList.tail.next;
        newList.size = size + 1;

        return newList;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        final ImmutableLinkedList newList;

        if (index > size || (index == 0 && size == 0)) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            newList = add(e);
        } else {
            newList = copy();

            Node currNode = newList.head;
            int i = 0;

            while (currNode != null) {
                if (i == index) {
                    Node nd = new Node(e);
                    nd.previous = currNode.previous;
                    nd.next = currNode;
                    currNode.previous = nd;
                }
                currNode = currNode.next;
            }

        }

        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        final ImmutableLinkedList newList;

        if (size == 0) {
            newList = new ImmutableLinkedList(c);
        } else {
            newList = copy();
            Node currNode = newList.tail;
            int len = c.length;

            for (int i = 0; i < len; i++) {
                Node nd = new Node(c[i]);
                currNode.next = nd;
                nd.previous = currNode;
                currNode = nd;
            }
        }

        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        final ImmutableLinkedList newList = copy();

        if (index > size || (index == 0 && size == 0)) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            newList.addAll(c);
        } else {
            Node currNode = newList.head;
            Node nextOriginal;
            Node nd;
            int i = 0;
            int len = c.length;

            while (i != index) {
                currNode = currNode.next;
            }
            nextOriginal = currNode.next;

            for (int j = 0; j < len; j++) {
                nd = new Node(c[j]);
                currNode.next = nd;
                nd.previous = currNode;
                currNode = nd;
            }

            currNode.next = nextOriginal;
            nextOriginal.previous = currNode;

        }
        return newList;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        Node currNode = head;

        while (i != index) {
            currNode = currNode.next;
            i++;
        }

        return currNode.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        final ImmutableLinkedList newList = copy();

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            newList.head = newList.head.next;
        }

        int i = 0;
        Node currNode = newList.head;

        while (i != index) {
            currNode = currNode.next;
            i++;
        }

        currNode.previous.next = currNode.next;
        currNode.next.previous = currNode.previous;

        return newList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        final ImmutableLinkedList newList = copy();

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            newList.head = newList.head.next;
        }

        int i = 0;
        Node currNode = newList.head;

        while (i != index) {
            currNode = currNode.next;
            i++;
        }

        currNode.data = e;

        return newList;
    }

    @Override
    public int indexOf(Object e) {
        if (size == 0) {
            return -1;
        }

        Node currNode = head;
        int i = 0;

        while (currNode != null) {
            if (currNode.data == e) {
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
        final ImmutableLinkedList newList = new ImmutableLinkedList();
        return newList;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];

        Node currnode = head;
        int i = 0;
        while (currnode != null) {
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
        if (size == 0) {
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList(head.data);

        Node currNode1 = head;
        Node currNode2 = newList.head;
        Node last = null;

        while (currNode1 != null) {
            Node nd = new Node(currNode1.data);
            currNode2.next = nd;
            currNode2.next.previous = currNode2;
            last = nd;
            currNode2 = currNode2.next;
            currNode1 = currNode1.next;
        }
        newList.tail = last;
        newList.size = size;

        return newList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        final ImmutableLinkedList newList = copy();
        Node nd = new Node(e);

        if (newList.size == 0) {
            newList.head = nd;
            newList.tail = nd;
        } else {
            nd.next = newList.head;
            newList.head = nd;
        }

        newList.size = size + 1;
        return newList;
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        if (head != null) {
            return head.data;
        }

        return null;
    }

    public Object getLast() {
        if (tail != null) {
            return tail.data;
        }

        return null;
    }

    public ImmutableLinkedList removeFirst() {
        final ImmutableLinkedList newList = copy();

        newList.head = newList.head.next;
        newList.head.previous = null;

        return newList;
    }

    public ImmutableLinkedList removeLast() {
        final ImmutableLinkedList newList = copy();

        newList.tail = newList.tail.previous;
        newList.tail.next = null;

        return newList;
    }
}
