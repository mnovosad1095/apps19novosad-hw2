package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private int size = 0;
    private Object[] elements;
    
    public ImmutableArrayList(Object[] arr){
        elements = arr;
        size = arr.length;
    }

    @Override
    public ImmutableList add(Object e){
        Object[] new_elemnts = new Object[size + 1];

        for (int i = 0; i < size; i++ ){
            new_elemnts[i] = elements[i];
        }
        new_elemnts[size] = e; 

        final ImmutableArrayList new_list = new ImmutableArrayList(new_elemnts);
        
        return new_list;
    }

    @Override
    public ImmutableList add(int index, Object e){
        if ( index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] new_elemnts = new Object[size++];

        for (int i = 0; i < index; i++ ){
            new_elemnts[i] = elements[i];
        }
        
        new_elemnts[index] = e;
        
        for ( int i = index + 1; i < size + 1; i++ ){
            new_elemnts[i] = elements[i-1];
        } 

        final ImmutableArrayList new_list = new ImmutableArrayList(new_elemnts);
        
        return new_list;
    }

    @Override
    public ImmutableList addAll(Object[] c){
        int len = c.length;
        Object[] new_elements = new Object[size + len];

        for ( int i = 0; i < size + len; i++ ){
            if ( i < size ){
                new_elements[i] = elements[i];
            } else {
                new_elements[i] = c[i - size];
            }
        }   
        
        final ImmutableArrayList new_list = new ImmutableArrayList(new_elements);
        
        return new_list;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c){
        if ( index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        int len = c.length;
        Object[] new_elements = new Object[size + len];

        for ( int i = 0; i < size + len; i++ ) {
            if ( i < index) {
                new_elements[i] = elements[i];
            } else if ( i >= index && i < index + len ) {
                new_elements[i] = c[i - index];
            } else {
                new_elements[i] = elements[i - len];
            }
        }

        final ImmutableArrayList new_list = new ImmutableArrayList(new_elements);
        
        return new_list;
    }

    @Override
    public Object get(int index){
        if ( index > size) {
            throw new IndexOutOfBoundsException();
        }

        return elements[index];
    }

    @Override
    public ImmutableList remove(int index){
        if ( index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] new_elements = new Object[size - 1];

        for ( int i = 0; i < size - 1; i++ ) {
            if ( i < index ) {
                new_elements[i] = elements[i];
            } else if ( i == index ) {
                continue;
            } else {
                new_elements[i] = elements[i + 1];
            }
        }    

        final ImmutableArrayList new_list = new ImmutableArrayList(new_elements);

        return new_list;
    }

    @Override
    public ImmutableList set(int index, Object e){
        if ( index > size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] new_elements = elements.clone();

        new_elements[index] = e;

        final ImmutableArrayList new_list = new ImmutableArrayList(new_elements);
        
        return new_list;
    }

    @Override
    public int indexOf(Object e){
        for ( int i = 0; i < size; i++ ) {
            if ( elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public ImmutableList clear(){
        Object[] new_elements = new Object[0];

        final ImmutableArrayList new_list = new ImmutableArrayList(new_elements);
        
        return new_list;
    }

    @Override
    public boolean isEmpty(){
        if ( size == 0 ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object[] toArray(){
        return elements;
    }

    @Override
    public String toString(){
        return new String();
    }

    
}
