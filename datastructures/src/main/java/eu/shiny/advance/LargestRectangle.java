package eu.shiny.advance;

import java.util.Scanner;

/**
 * Created by e1065894 on 09-Dec-15.
 */
public class LargestRectangle {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] st = new int[4*n -1];
        for(int i =0; i <n; ++i){
            a[i] = in.nextInt();
        }

        constructSt(a, st, 0, n-1, 0);
        int maxarea = getMaxArea(a, st, n-1, 0, n-1);

        System.out.println(maxarea);

    }
    static int getMaxArea(int[] a, int[] st, int n, int ql, int qh){
        if(ql > qh){
            return -1;
        }
        if(ql == qh){
            return a[ql];
        }

        int m = getmin(a, st, 0, n, ql, qh, 0);

        return max(getMaxArea(a, st, n, ql, m -1), getMaxArea(a, st, n, m +1, qh), (qh -ql +1)*a[m] );
    }

    static int max(int n1, int n2, int n3){
        int max = n1;
        if(n2 > max){
            max = n2;
        }
        if(n3 > max){
            max= n3;
        }

        return max;
    }

    static void constructSt(int[] a, int[] st, int low, int high, int pos){

        if(low == high){
            st[pos] = low;
            return;
        }
        int mid = (low + high)/2;

        constructSt(a, st, low, mid, 2*pos +1);
        constructSt(a, st, mid + 1, high, 2*pos +2);
        st[pos] = min(a, st[2*pos +1 ], st[2*pos +2]);
    }

    static int getmin(int[] a, int[] st, int low, int high, int ql, int qh, int pos){
        if(ql<=low && qh>=high){
            return st[pos];
        }else if(qh < low ||ql > high){
            return -1;
        }else{
            int mid = (low +high)/2;
            return min(a, getmin(a, st, low, mid, ql, qh, 2*pos +1),
                    getmin(a, st, mid + 1, high, ql, qh, 2*pos +2));

        }

    }

    static int min(int[] a, int num1, int num2){
        if(num1 == -1){
            return num2;
        }else if(num2 == -1){
            return num1;
        }else

            return a[num1]>a[num2] ? num2 : num1;
    }
}
