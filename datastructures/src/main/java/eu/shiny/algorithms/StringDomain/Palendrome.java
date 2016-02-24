package eu.shiny.algorithms.StringDomain;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Scanner;

/**
 *Created by mukulagrawal on 1/31/16.
 */
public class Palendrome {

    public static int[][] lpsarry(char[] arr){
        int[][] pal = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length -1; ++i){
            pal[i][i] = 1;
            if(arr[i] == arr[i+1]){
                pal[i][i+1] = 2;
            }else{
                pal[i][i+1] = 1;
            }
        }

        pal[arr.length-1][arr.length -1] = 1;

        for(int d = 2 ; d < arr.length ; ++d){
            for(int i = 0; i < arr.length - d; ++i){
                int j = i + d ;
                if(arr[i] == arr[j]){
                    pal[i][j] = pal[i+1][j-1] + 2;
                }else{
                    pal[i][j] = Math.max(pal[i+1][j], pal[i][j-1]);
                }
            }
        }

        return pal;

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());

        while(t > 0){
            String str1 = in.nextLine();
            String str2 = in.nextLine();

            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();

            int[][] lpsarr1 = lpsarry(char1);
            int[][] lpsarr2 = lpsarry(char2);

            int result = 0;

            int length1 = lpsarr1[0][char1.length - 1];

            int length2 = lpsarr2[0][char2.length - 1];

            if(length1 % 2 == 0 || length2 % 2 == 0){
                result = length1 + length2;
            }else {
                result = length1 + length2;

                //////////

                ////

                char[] arr1 = getCentralofPalendrome(char1, lpsarr1);
                char[] arr2 = getCentralofPalendrome(char2, lpsarr2);

                boolean isSameCentralCharFound = false;

                for (char c: arr1) {
                    if(Arrays.binarySearch(arr2, c) >= 0){
                        isSameCentralCharFound = true;
                        break;
                    }
                }


                if(!isSameCentralCharFound){
                    result--;
                }
            }


            System.out.println(result);
            --t;
        }
    }

    public static char[] getCentralofPalendrome(char[] arr, int[][] pal){
        char c = 0;

        int i = 0;
        int j = arr.length -1;

        int index = pal[0][j] -1;

        int central = index/2;

        while(index > central && j > i){
            if(arr[i] == arr[j]){
                i++;
                j--;
                --index;
                c = arr[i];
            }else if(pal[i+1][j] > pal[i][j-1]) {
                i++;
            }else {
                j--;
            }

        }

        char[] centralChar = new char[j -i + 1];
        int m = 0;
        while (j>=i){
            centralChar[m] = arr[i];
            ++i;
            m++;
        }

        Arrays.sort(centralChar);

        return centralChar;
    }



}
