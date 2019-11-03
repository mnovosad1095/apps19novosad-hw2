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
        Object[] newElements_ = new Object[size + 1];

        for (int i = 0; i < size; i++) {
            newElements_[i] = elements[i];
        }
        newElements_[size] = e;

        final ImmutableArrayList NewList = 
            new ImmutableArrayList(newElements_);

        return NewList;
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newElements_ = new Object[size++];

        for (int i = 0; i < index; i++) {
            newElements_[i] = elements[i];
        }

        newElements_[index] = e;

        for (int i = index + 1; i < size + 1; i++) {
            newElements_[i] = elements[i - 1];
        }

        final ImmutableArrayList NewList = 
            new ImmutableArrayList(newElements_);

        return NewList;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        int len = c.length;
        Object[] newElements_ = new Object[size + len];

        for (int i = 0; i < size + len; i++) {
            if (i < size) {
                newElements_[i] = elements[i];
            } else {
                newElements_[i] = c[i - size];
            }
        }

        final ImmutableArrayList NewList = 
            new ImmutableArrayList(newElements_);

        return NewList;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        int len = c.length;
        Object[] newElements_ = new Object[size + len];

        for (int i = 0; i < size + len; i++) {
            if (i < index) {
                newElements_[i] = elements[i];
            } else if (i >= index && i < index + len) {
                newElements_[i] = c[i - index];
            } else {
                newElements_[i] = elements[i - len];
            }
        }

        final ImmutableArrayList NewList = 
            new ImmutableArrayList(newElements_);

        return NewList;
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

        Object[] newElements_ = new Object[size - 1];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                newElements_[i] = elements[i];
            } else if (i == index) {
                continue;
            } else {
                newElements_[i - 1] = elements[i];
            }
        }

        final ImmutableArrayList NewList = 
            new ImmutableArrayList(newElements_);

        return NewList;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newElements_ = elements.clone();

        newElements_[index] = e;

        final ImmutableArrayList NewList =
             new ImmutableArrayList(newElements_);

        return NewList;
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
        Object[] newElements_ = new Object[0];

        final ImmutableArrayList NewList = 
            new ImmutableArrayList(newElements_);

        return NewList;
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
