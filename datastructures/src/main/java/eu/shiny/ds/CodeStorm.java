package eu.shiny.ds;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by e1065894 on 29-Oct-15.
 */
public class CodeStorm {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A[] = new int[N];
        for (int A_i = 0; A_i < N; A_i++) {
            A[A_i] = in.nextInt();
        }
        int acute = 0;
        int right = 0;
        int obtuse = 0;

        for (int i = 0; i < N - 2; ++i) {
            Double s1 = Double.valueOf(A[i]);
            for (int j = i + 1; j < N - 1; ++j) {
                Double s2 = Double.valueOf(A[j]);
                int hypo = (int) Math.sqrt(s1 * s1 + s2 * s2);
                int k = j + 1;
                while(k < N-1 && A[k] < A[i] + A[j]){
                    k++;
                }
                if(k - j < 2){
                    continue;
                }else{
                    int i1 = Arrays.binarySearch(A, hypo);
                    if(i1 >=0){
                        right++;
                        obtuse = obtuse + k - i1;
                        acute = acute + i1 - j;
                    }else{
                        for (int m = j + 1; m <=k; ++m) {
                            Double s3 = Double.valueOf(A[k]);
                            if (s3 > hypo) {
                                obtuse = obtuse + k -m;
                                break;
                            } else {
                                acute++;
                            }
                        }

                    }
                }
            }
        }
        System.out.print(acute + " " + right + " " + obtuse);
        // your code goes here
    }

//    public static void main(String[] args) {
//
//
//        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
//        try
//        {
//            int T= Integer.parseInt(inp.readLine());
//
//            for(int i=0;i<T;i++)
//            {
//                int n= Integer.parseInt(inp.readLine());
//                int[] arr = new int[n];
//                for (int j= 0; j<n; ++j){
//                    arr[j] = j+1;
//                }
//                int size = n;
//                int thrower = 0;
//                int winner = -1;
//                int victim = -1;
//
//                while(size > 1){
//                    if(size % 2 != 0){
//                        arr[thrower] = -1;
//                    }else{
//                        victim = arr[thrower] + size/2;
//                        if(victim >n){
//                            victim = victim % n;
//
//                        }
//
//                        arr[victim -1] = -1;
//                        winner = thrower;
//                        thrower++;
//                        thrower = thrower%n;
//                    }
//                    while(arr[thrower] == -1){
//                        thrower++;
//                    }
//                    thrower = thrower%n;
//                    size--;
//                }
//                //Your code goes here
//                System.out.println(arr[winner]);
//            }
//        }
//        catch(Exception e){}
//
//
//    }

}
