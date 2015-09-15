package eu.shiny.ds;


public class Queue<T> extends AbstractVector<T> {

    private int front = -1;
    private int rear = -1;
    
    public Queue(int size){
        super(size);
    }
    
    @Override
    public boolean isEmpty() {
        return rear == -1 || front > rear;     
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return arr[front];
    }

    @Override
    public T poll() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return arr[front++];
    }
    
    @Override
    public T push(T t) {
        if (rear < size - 1) {

            if (front == -1) {
                front++;
            }

            arr[++rear] = t;
            return t;
        }
        return null;
    }

    @Override
    public int search(T t) {
        for(int i = front; i <= rear; ++i){
            if(arr[i].equals(t)) return i;
        }
        
        return -1;
    }
    
    public void print(){
        int index = front;
        System.out.println("Size of the Queue is : " + size());
        while(index <= rear){
            System.out.println("| " + arr[index++].toString() + " |"  );
            System.out.println("------");
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(10);
        queue.push(10);
        queue.push(11);
        queue.push(12);
        queue.push(13);
        queue.push(1);
        
//        queue.poll();
        
        queue.print();
    }

    @Override
    public int size() {
        if(isEmpty()) return 0;
        
        return rear - front + 1;
    }
}
