package eu.shiny.algorithms.StringDomain;

import java.util.Scanner;

/**
 * Created by mukulagrawal on 2/4/16.
 */
public class ReverseShuffleMerge {

        public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();

            int[] arr = new int[26];
            String result = "";

            for(int i = 0; i <line.length(); ++i){
                int index = line.charAt(i) - 'a';
                arr[index] += 1;
            }

            int[] freq = new int[26];
            int[] occ = new int[26];

            int lastFound = line.length();

            for(int j = line.length()-1 ;j >=0; --j ){
                char character = line.charAt(j);

                int index = character - 'a';

                freq[index] += 1;

                //avoid the character as long as possible
                //if(urgent && not over used)
                //if([freq[index] > arr[index]/2 && ] && [freq[index] <= arr[index] && occ[index] < arr[index]/2])
                if((freq[index] - occ[index]) > arr[index]/2 && freq[index] <= arr[index] && occ[index] < arr[index]/2){
                    //find the shortest subsequence to append before the character
                    //characters to form the subsequence shoudl be eligible frequency and occurence

                    String smallestPrefix = "";
                    String prefix = "";

                    boolean shouldChooseEqual = false;

                    if(j > 0){
                        char nextCharacter = line.charAt(j -1);
                        if(nextCharacter > character){
                            shouldChooseEqual = true;
                        }
                    }

                    for(int k = lastFound - 1; k > j; --k ){
                        char minCharacter = line.charAt(k);
                        if(((minCharacter < character) || (shouldChooseEqual && minCharacter == character))
                                && freq[minCharacter - 'a'] < arr[minCharacter - 'a']
                                && occ[minCharacter - 'a'] < arr[minCharacter - 'a']/2 ){

                            prefix = prefix + minCharacter;
                        }
                    }

                    if(prefix.length() > 0){
                        //find smallest susequence of the prefix
                        prefix = geSmallestLongestSubsequence(prefix, 0, "");

                        //update the occurrence and frequency
                        for(int l = 0; l<prefix.length() ; ++l){
                            int minIndex = prefix.charAt(l) - 'a';
                            if(occ[minIndex] < arr[minIndex]/2){
                                smallestPrefix += String.valueOf(prefix.charAt(l));
                                occ[minIndex] += 1;
                            }
//                            freq[minIndex] = freq[minIndex] < 1 ? 0 : freq[minIndex] - 1;

                        }
                    }

                    lastFound = j;
                    occ[character - 'a'] += 1;
                    result = result + smallestPrefix + String.valueOf(character);
                }
            }

            System.out.print(result);
        }

    public static String geSmallestLongestSubsequence(String input, int start, String result){
        if(input.length() == 1) return input;

        else if(start > input.length() -1){
            return result;
        }else{
            int[] alpha = new int[26];
            int minchar = 25;
            int newStart = 0;
            for(int i = start; i < input.length() ; ++i){
                if(input.charAt(i) - 'a' <= minchar){
                    minchar = input.charAt(i) - 'a';
                    newStart = i;
                }
                alpha[input.charAt(i) - 'a'] +=1;
            }

            int fre = alpha[minchar];

            while (fre > 0){
                result += String.valueOf(Character.valueOf((char)('a' + minchar)));
                --fre;
            }

            return geSmallestLongestSubsequence(input, newStart + 1, result );
        }

    }
}
