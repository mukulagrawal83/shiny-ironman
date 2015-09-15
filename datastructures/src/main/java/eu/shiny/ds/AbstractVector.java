package eu.shiny.ds;

import java.lang.reflect.Array;

public abstract class AbstractVector<T> implements DataStructure<T> {
    
    final int size;
    final T[] arr;
    
    public AbstractVector(int size){
        this.size = size;
        arr = (T[]) Array.newInstance(Object.class, size);
    }
    /**
     * Tests if this stack is empty.
     */
    public abstract boolean isEmpty();

    
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    public abstract T peek();

    
    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     */
    public abstract T poll();

    /**
     * Pushes an item onto the top of this stack.
     */
    public abstract T push(T t);

    /**
     * Returns the 1-based position where an object is on this stack.
     */
    public abstract int search(T t);
    
    public abstract int size();

}
