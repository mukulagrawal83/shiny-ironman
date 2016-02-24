package eu.shiny.algorithms.StringDomain;

import java.util.*;

/**
 * Created by mukulagrawal on 2/18/16.
 */
public class SherlockAndAnagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while(t > 0){
            int result = 0;
            String input = in.nextLine();
            Map<String, Integer> countMap = new HashMap<String, Integer>();
            int length = input.length();

            for(int l = 1; l < length ; ++l){
                for(int i = 0; i <= length - l; ++i){
                    String sub = input.substring(i, i + l);
                    char[] charArray = sub.toCharArray();
                    Arrays.sort(charArray);

                    String key = String.valueOf(charArray);
                    int count = countMap.get(key) != null ? countMap.get(key) : 0;

                    countMap.put(key, ++count);
                }
            }

            for (int value: countMap.values()) {
                if(value > 1)
                result += fact(value)/(fact(value -2) * 2) ;
            }

            System.out.println(result);
            --t;
        }

    }

    public static double fact(int num){
        if(num <= 1){
            return 1;
        }

        return num * fact(num -1);
    }
}
