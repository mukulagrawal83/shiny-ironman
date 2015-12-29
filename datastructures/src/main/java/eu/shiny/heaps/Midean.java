package eu.shiny.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by e1065894 on 02-Dec-15.
 */
public class Midean {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Integer> minheap = new PriorityQueue();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int count = 0;

        for(int i = 0; i < n; ++i){
            //insert the val
            int val = in.nextInt();

            if(count % 2 == 0){
                maxHeap.offer(val);
            }else{
                minheap.offer(val);
            }

            if(!minheap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minheap.peek()){
                int temp = maxHeap.poll();
                maxHeap.offer(minheap.poll());
                minheap.offer(temp);
            }

            count++;

            //find midean
            if(count % 2 == 0 ){
                System.out.println((double) (minheap.peek() + maxHeap.peek())/2);
            }else {
                System.out.println((double) maxHeap.peek());
            }

        }

    }

}
