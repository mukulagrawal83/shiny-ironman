package eu.shiny.heaps;

/**
 * Created by e1065894 on 30-Nov-15.
 */
public class BinaryHeap {

    private final int capacity;

    private final int[] arr;

    private int heapSize = 0;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int leftChild(int i){
        return 2*i  + 1;

    }

    public int rightChild(int i){
        return 2*i + 2;
    }

    public int parent(int i){
        return (i -1)/2;
    }


    public void insert(int val){
        arr[heapSize++] = val;
        int cur = heapSize -1 ;

        while (cur > 0 && arr[parent(cur)] > arr[cur]){
            heapify(parent(cur));
            cur = parent(cur);
        }
    }

    public void heapify(int curr){

        int left = leftChild(curr);
        int right = rightChild(curr);

        int index = -1;
        if(left < heapSize || right < heapSize){
            if(arr[left] < arr[right]){
                if(left < heapSize){
                    index = left;
                }else {
                    index = right;
                }
            }else if(arr[right] < arr[left]){
                if(right < heapSize){
                    index = right;
                }else {
                    index = left;
                }
            }

            if(arr[curr] > arr[index] ){
                int temp = arr[curr];
                arr[curr] = arr[index];
                arr[index] = temp;

                heapify(index);
            }
        }

    }

    public void printHeap(){
        for (int i: arr){
            System.out.println(i);

        }
    }

    public int deleteMin(){
        int result =  arr[0];
        arr[0] = arr[--heapSize];
        heapify(0);

        return  result;
    }
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10);

        heap.insert(10);
        heap.insert(1);
        heap.insert(2);
        heap.insert(4);
        heap.insert(5);
        heap.insert(89);
        heap.insert(7);
        heap.insert(3);


        heap.printHeap();

        System.out.println("lets see the heap sort");
        for(int i = 0; i < 8; ++i){
            System.out.println(heap.deleteMin());
        }
    }



}
