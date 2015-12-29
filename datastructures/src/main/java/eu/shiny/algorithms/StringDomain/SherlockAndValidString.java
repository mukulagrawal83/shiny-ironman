package eu.shiny.algorithms.StringDomain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by e1065894 on 28-Dec-15.
 */
public class SherlockAndValidString {

    public static void main(String[] args) {
         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String result = "YES";

        int[] arr = new int[26];
        int len = 0;

        for(int i = 0; i < input.length(); ++i){
            int index = input.charAt(i) % 26;
            if(arr[index] == 0){
                len++;
            }
            arr[index] += 1;

        }


        int[] unique = new int[len];
        int start = 0;
        for (int i = 0; i < 26; ++i){
            if(arr[i] != 0){
                unique[start++] = arr[i];
            }
        }

        Arrays.sort(unique);

        int diff = 0;

        int stt = 0 ;
        int endd = len -1;

        while (endd > stt){
            if(unique[endd] != unique[stt]){
                if (unique[endd] == 1 || unique[stt] == 1){
                    diff += 1;
                }else {
                    diff += Math.abs(unique[endd] - unique[stt]);
                }
            }
            if(diff > 1){
                result = "NO";
                break;
            }
            stt++;
            endd--;
        }

        System.out.print(result);

        String i1 = "";
        String i2 = "";

        char[] chars = i1.toCharArray();
        char[] chars1 = i2.toCharArray();

    }
}
