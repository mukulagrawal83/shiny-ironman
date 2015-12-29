package eu.shiny.advance;

import java.util.Arrays;

/**
 * Created by e1065894 on 09-Dec-15.
 */
public class SegmentedSumTree {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; ++i){
//            arr[i] = in.nextInt();
//        }
//
//        int[] tree = new int[4*n -1];
//        constructSegmentedTree(arr, tree, 0 , n-1, 0);
//        System.out.print(getSum(arr, tree, 0, n-1, 0, 2, 0));

        int[] arr = {99999, 333, 34, 35, 36};
        System.out.print("index is :" + Arrays.binarySearch(arr, 34));

    }

    private static void constructSegmentedTree(int[] arr, int[] tree, int low, int high, int pos) {
        if(low == high){
            tree[pos] = arr[low];
            return;
        }
        int mid = (low + high)/2 ;

        constructSegmentedTree(arr, tree, low, mid, 2*pos + 1);
        constructSegmentedTree(arr, tree, mid + 1, high , 2*pos + 2);
        tree[pos] = tree[2*pos + 1] + tree[2*pos + 2];
    }

    private static int getSum(int[] arr, int[] tree, int low, int high, int ql, int qh, int pos){
        if(ql <= low && qh >= high){
            return tree[pos];
        }else if(ql > high || qh < low ){
            return 0;
        }else {
            int mid = (low + high)/2;
            return getSum(arr, tree, low, mid, ql, qh, 2*pos + 1) +
                    getSum(arr, tree, mid + 1, high, ql, qh, 2*pos + 2);
        }
    }

    private static void updateTree(int[] arr, int[] tree, int low, int high, int pos, int index){
        if(index < low || index > high){
            return;
        }else {
            tree[pos] = tree[pos] - arr[index];
            int mid = (low + high)/2;
            updateTree(arr, tree, low, mid, 2*pos + 1, index);
            updateTree(arr, tree, mid + 1, high, 2*pos + 2, index);
        }
    }

}
