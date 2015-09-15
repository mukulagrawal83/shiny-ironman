
package eu.shiny.hackathon;

import java.util.Arrays;

public class MinimumtimeToMergeSort {
    
    static long total = 0;
    
    public static void main(String[] args) {
        int[] A={1000,250, 100};
        
        System.out.print(totalTime(A));
    }
    
    public static long totalTime(int[] x){
        for(int i = x.length; i >= 2 ; --i){
            if(i == 2) {
                return  total + x[0] + x[1];
            }
            total = total + x[i-1] + totalTime(Arrays.copyOfRange(x, 0, i -1));
        }
        return total;
    }
    

}
