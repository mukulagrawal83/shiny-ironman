package eu.shiny.ds;

import java.util.Scanner;

/**
 * Created by e1065894 on 31-Oct-15.
 */
public class Adobe {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        int[] even = new int[n/2];
        int[] odd = new int[n/2];
        int swap = 0;

        for(int i = 0; i <n; ++i){
            int num =in.nextInt();
            if(i%2==0){
                if(num%2 == 0){
                    swap++;
                    even[i] = num;
                }else{
                    odd[i] = num;
                }
            }else{
                if(num%2 != 0){
                    swap++;
                    odd[i] = num;
                }else{
                    even[i] = in.nextInt();
                }
            }
        }

        //find swaps for even
        swap = swap + swaps(even);
        swap = swap + swaps(odd);

        System.out.print(swap);

    }

    static int swaps(int[] arr){
        int swap = 0;
        for(int i = 0; i <arr.length; ++i){
            int min = arr[i];
            int swapIndex = 0;

            for(int j =i+1; j <arr.length; ++j){
                if(arr[j] < min){
                    min = arr[j];
                    swapIndex = j;
                }
            }
            if(arr[i] != arr[swapIndex]){
                int temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
                swap++;
            }

        }

        return swap;
    }

}

