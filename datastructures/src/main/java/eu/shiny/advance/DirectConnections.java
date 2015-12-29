package eu.shiny.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by e1065894 on 08-Dec-15.
 */
public class DirectConnections {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0){
            long result = 0;
            int n = in.nextInt();

            int cordinates[] = new int[n];
            int population[] = new int[n];

            long[] tree = new long[4*n -1];
            int[] countTree = new int[4*n -1];

            for(int i = 0; i < n; ++i){
                cordinates[i] = in.nextInt();
            }

            List<City> cities = new ArrayList<City>(n);

            for(int i = 0; i < n; ++i){
                population[i] = in.nextInt();
                cities.add(new City(cordinates[i], population[i]));
            }

            Collections.sort(cities);

            Arrays.sort(population);

            Arrays.sort(cordinates);

            constructSegmentedTree(cordinates, tree, 0 , n-1, 0);
            constructCountTree(countTree, 0, n-1, 0);


            for (int i = 0; i < n-1; ++i){
                City city = cities.get(i);

                int index = Arrays.binarySearch(cordinates, city.cordinate);

                long rightSum = getSum(cordinates, tree, 0, n - 1, index + 1, n - 1, 0);

                long leftSum = getSum(cordinates, tree, 0, n - 1, 0, index - 1, 0);

                long rightCount = getCount(countTree, 0, n-1, index + 1, n-1, 0);

                long leftCount = getCount(countTree, 0, n-1, 0, index -1, 0);

                //right side
//                System.out.println((city.population * Math.abs(rightSum - rightCount * city.cordinate)) % 1000000007);
                result+= (city.population * Math.abs(rightSum - rightCount * city.cordinate)) % 1000000007;

                //left side
//                System.out.println((city.population * Math.abs(leftSum - leftCount * city.cordinate)) % 1000000007);
                result+= (city.population * Math.abs(leftSum - leftCount * city.cordinate)) % 1000000007;

                updateTree(cordinates, tree, 0, n-1, 0, index);
                updateCountTree(countTree, 0, n-1, 0, index);
            }

            System.out.println(result % 1000000007);

            --t;
        }
    }

    private static void constructSegmentedTree(int[] arr, long[] tree, int low, int high, int pos) {
        if(low == high){
            tree[pos] = arr[low];
            return;
        }
        int mid = (low + high)/2 ;

        constructSegmentedTree(arr, tree, low, mid, 2*pos + 1);
        constructSegmentedTree(arr, tree, mid + 1, high , 2*pos + 2);
        tree[pos] = tree[2*pos + 1] + tree[2*pos + 2];
    }

    private static long getSum(int[] arr, long[] tree, int low, int high, int ql, int qh, int pos){
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

    private static void updateTree(int[] arr, long[] tree, int low, int high, int pos, int index){
        if(low == high && high == index){
            tree[pos] = tree[pos] - arr[index];
            return;
        }else if(index < low || index > high){
            return;
        }else {
            tree[pos] = tree[pos] - arr[index];
            int mid = (low + high)/2;
            updateTree(arr, tree, low, mid, 2*pos + 1, index);
            updateTree(arr, tree, mid + 1, high, 2*pos + 2, index);
        }
    }

    private static int getCount(int[] tree, int low, int high, int ql, int qh, int pos){
        if(ql <=low && qh >= high){
            return tree[pos];
        }else if(ql > high || qh < low){
            return 0;
        }else {
            int mid = (low + high)/2;
            return getCount(tree, low, mid, ql, qh, 2*pos + 1) +
                    getCount(tree, mid + 1, high, ql, qh, 2*pos + 2);
        }

    }

    private static void constructCountTree(int[] tree, int low, int high, int pos){
        if (low == high){
            tree[pos] = 1;
            return;
        }

        int mid = (low + high)/2;
        constructCountTree(tree, low, mid, 2*pos + 1);
        constructCountTree(tree, mid + 1, high, 2*pos + 2);
        tree[pos] = tree[2*pos + 1] + tree[2*pos + 2];

    }

    private static void updateCountTree(int[] tree, int low, int high, int pos, int index){
        if(low == high && high == index){
            tree[pos] = tree[pos] -1;
            return;
        }else if(index < low || index > high){
            return;
        }else{
            tree[pos] = tree[pos] -1;
            int mid = (low + high)/2;
            updateCountTree(tree, low, mid, 2*pos + 1, index);
            updateCountTree(tree, mid + 1, high, 2*pos + 2, index);
        }
    }

    public static class City implements Comparable<City>{
        public final int cordinate;
        public final int population;

        public City(int cordinate, int population) {
            this.cordinate = cordinate;
            this.population = population;
        }

        public int compareTo(City o) {
            return o.population - this.population;
        }

    }

}

