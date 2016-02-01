package eu.shiny.iSIGHTPartners;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by e1065894 on 10-Dec-15.
 */
public class Test {

    public static void main(String[] args) {
//        int[] A = {60, 80, 40};
//        int[] B = {2, 3, 5};
//        System.out.println(solution(A, B, 5, 2, 200));
        int[] A = {40, 40, 100, 80, 20};
        int[] B = {3, 3, 2, 2, 3};
        System.out.println(getStopsOfElevator(A, B, 3, 5, 2000));
    }


    public static int getLengthOfLongestValidPassword(String S) {
        int result = -1;

        if(S == null ||  S.trim().equals("")){
            return -1;
        }
        //split the string treating digits as delimiters
        String[] tokens = S.split("[0-9]");
        for (String token: tokens) {
            //hasuppercase?
            if(!token.trim().equals("") && !token.equals(token.toLowerCase())){
                if(token.length() > 0 && result < token.length()){
                    result = token.length();
                }
            }
        }

        return result;
    }

    public static int getStopsOfElevator(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        int count = 0;

        Stack<Integer> queue = new Stack<Integer>();
        Set<Integer> uniqueDestination = new HashSet<Integer>(B.length);

        //create a queue with peoples
        for(int i = A.length -1; i >=0; --i ){
            queue.push(A[i]);
        }

        //destination index for arr B
        int dest = 0;

        while (!queue.isEmpty()){
            int totalWeight = 0;
            int totalPerson = 0;
            while (!queue.isEmpty() && totalPerson < X && (totalWeight + queue.peek())<=Y){
                totalWeight += queue.pop();
                uniqueDestination.add(B[dest++]);
                totalPerson++;
            }

            count += uniqueDestination.size() + 1;
            uniqueDestination.clear();
        }

        return count;
    }
}
