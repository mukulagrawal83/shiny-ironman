package eu.shiny.booking.com;

import java.util.Scanner;

/**
 * Created by mukulagrawal on 2/20/16.
 */
public class HappinessScore {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        int result = 0;

        for(int i = 0; i < n; ++i){
            arr[i] = in.nextInt();
        }

        byte[] counter = new byte[arr.length];

        while (true) {
            // Print combination
            int sum = 0;

            for (int i = 0; i < counter.length; i++) {
                if (counter[i] != 0)
                    sum = sum + arr[i];
//                    System.out.print(arr[i] + " ");
            }
            if(isPrime(sum)){
                result++;
            }
//            System.out.println();

            // Increment counter
            int i = 0;
            while (i < counter.length && counter[i] == 1)
                counter[i++] = 0;
            if (i == counter.length)
                break;
            counter[i] = 1;
        }

        System.out.println(result);
    }


    public static boolean isPrime(int num){
        if(num == 2) return true;

        if(num % 2 == 0){
            return false;
        }

        for(int i = 3; i * i <= num ; i=i+2 ){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }



}
