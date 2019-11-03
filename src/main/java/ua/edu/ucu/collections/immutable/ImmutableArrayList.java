package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private int size = 0;
    private Object[] elements;

    public ImmutableArrayList(Object[] arr) {
        elements = arr;
        size = arr.length;
    }

    public ImmutableArrayList() {
        elements = new Object[0];
        size = 0;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] new_elemnts = new Object[size + 1];

        for (int i = 0; i < size; i++) {
            new_elemnts[i] = elements[i];
        }
        new_elemnts[size] = e;

        final ImmutableArrayList newList = new ImmutableArrayList(new_elemnts);

        return newList;
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] new_elemnts = new Object[size++];

        for (int i = 0; i < index; i++) {
            new_elemnts[i] = elements[i];
        }

        new_elemnts[index] = e;

        for (int i = index + 1; i < size + 1; i++) {
            new_elemnts[i] = elements[i - 1];
        }

        final ImmutableArrayList newList = new ImmutableArrayList(new_elemnts);

        return newList;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        int len = c.length;
        Object[] newElements = new Object[size + len];

        for (int i = 0; i < size + len; i++) {
            if (i < size) {
                newElements[i] = elements[i];
            } else {
                newElements[i] = c[i - size];
            }
        }

        final ImmutableArrayList newList = new ImmutableArrayList(newElements);

        return newList;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        int len = c.length;
        Object[] newElements = new Object[size + len];

        for (int i = 0; i < size + len; i++) {
            if (i < index) {
                newElements[i] = elements[i];
            } else if (i >= index && i < index + len) {
                newElements[i] = c[i - index];
            } else {
                newElements[i] = elements[i - len];
            }
        }

        final ImmutableArrayList newList = new ImmutableArrayList(newElements);

        return newList;
    }

    @Override
    public Object get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        return elements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newElements = new Object[size - 1];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                newElements[i] = elements[i];
            } else if (i == index) {
                continue;
            } else {
                newElements[i - 1] = elements[i];
            }
        }

        final ImmutableArrayList newList = new ImmutableArrayList(newElements);

        return newList;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newElements = elements.clone();

        newElements[index] = e;

        final ImmutableArrayList newList = new ImmutableArrayList(newElements);

        return newList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableArrayList clear() {
        Object[] newElements = new Object[0];

        final ImmutableArrayList newList = new ImmutableArrayList(newElements);

        return newList;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public String toString() {
        return new String();
    }
}
