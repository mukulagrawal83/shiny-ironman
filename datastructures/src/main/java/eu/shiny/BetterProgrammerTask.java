package eu.shiny;

import java.util.Collections;
import java.util.List;


public class BetterProgrammerTask {
    
    public static int countWords(String s) {
        if(s == null || s.trim().length() == 0){
            return 0;
        }



        int count = 1;
        s = s.trim();
        /*
          Please implement this method to return the word count in a given String.

          The words in the parameter String can be separated from each other by any nubmer
          of whitespace symbols (Character.isWhitespace()).
         */
        for(int i =0; i < s.length()-1; ++i){
            if(Character.isWhitespace(s.charAt(i)) && !Character.isWhitespace(s.charAt(i + 1))){
                ++count;
            }
            
        }
        return count;
    }
    
    public static void main(String[] args) {
        BetterProgrammerTask task = new BetterProgrammerTask();
        System.out.print(task.countWords("abcba"));
    }

}
