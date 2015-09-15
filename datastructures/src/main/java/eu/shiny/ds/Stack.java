package eu.shiny.ds;

import java.lang.reflect.Array;

@SuppressWarnings("unused")
public class Stack<T extends Object> extends AbstractVector<T> {

    private int rear = -1;
    
    public Stack(int size) {
        super(size);
    }

    @Override
    public boolean isEmpty() {
        return rear == -1;
    }

    @Override
    public T peek() {
        if(rear == -1) {
            System.out.println("stack is empty");
            return null;
        }
        
        return arr[rear];
    }

    @Override
    public T poll() {
        if(rear == -1) {
            System.out.println("stack is empty");
            return null;
        }
        
        return arr[rear--];
    }

    @Override
    public T push(T t) {
        if(rear == size -1) {
            System.out.println("Stack is full");
            return null;
        }
        
        arr[++rear] = t;
        return t;
    }

    @Override
    public int search(T t) {
        int index = -1;
        for(int i = 0; i <= rear; ++i ){
            if(arr[i].equals(t)){
                return i;
            } 
        }
        
        return -1;
    }
    
    public void print(){
        int index = rear;
        System.out.println("size of the stack is : " + size());
        System.out.println("==>");
        while(index >= 0){
            System.out.println("  | " + arr[index--].toString() + " |"  );
            System.out.println("  ------");
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(10);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(1);
        
        stack.poll();

        stack.print();
    }

    @Override
    public int size() {
        return rear + 1;
    }

}
