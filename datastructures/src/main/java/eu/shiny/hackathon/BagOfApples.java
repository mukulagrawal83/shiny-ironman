package eu.shiny.hackathon;

import java.util.Arrays;
import java.util.Scanner;

public class BagOfApples {
    int min ;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalBags = scanner.nextInt();
        int[] a = new int[totalBags] ;
        
        while(totalBags > 0){
            a[--totalBags] = scanner.nextInt();
        }
        
        Arrays.sort(a);
        long sum = 0;
        
        for(int i = 0 ; i < a.length ; ++i){
            sum = sum + a[i];
        }            
        
        int temp = -1;
        
        for(int i = 0 ; i < a.length ; ++i){
            int r = (int) (sum % 3);
            if (r == 0) {
                System.out.println(sum);
                break;
            }
            
            if(a[i] % 3 == r){
                if(temp == -1){
                    temp = a[i];
                }
                
                if(temp > a[i] ){
                    temp = a[i];
                }
            }
            
            sum = sum - temp;
        }
        
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
    
//    public int findsum(int[] a, int num){
//        int temp = -1;
//        int combi = 0 ;
//        for(int i = 0; i < a.length ; ++i){
//            if(a[i] % 3 == num){
//                if(temp == -1){
//                    temp = a[i];
//                }
//                if(temp > a[i]){
//                    temp = a[i];
//                }
//            }else if(){
//
//            }
//
//
//        }
//
//
//
//        return temp;
//    }
    

}
