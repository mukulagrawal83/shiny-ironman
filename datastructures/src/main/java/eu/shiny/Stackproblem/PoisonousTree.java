
package eu.shiny.Stackproblem;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by e1065894 on 13-Nov-15.
 */
public class PoisonousTree {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        int[] dayOfDeath = new int[n];
        for(int i = 0; i <arr.length; ++i){
            arr[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack1 = new Stack<Integer>();

        int result = 0;
        int count = 0;
        for(int i = 0; i <arr.length; ++i){
            if(!stack.isEmpty() && arr[i] > stack.peek()){
                if(arr[i] > arr[i-1]){
                    count = 1;
                    dayOfDeath[i] = count;
                    stack1.push(i-1);
                }else{
                    if(arr[i] > arr[stack1.peek()]){
                        count++;
                        dayOfDeath[i] = count;
                    }else{
                        int temp = 0;
                        count++;
                        while (!stack1.isEmpty() && arr[stack1.peek()] >= arr[i]){
                            temp = Math.max(temp, dayOfDeath[stack1.peek()]);
                            stack1.pop();
                        }
                        if(count <= temp){
                            count = temp + 1;
                        }
                        dayOfDeath[i] = count;
                        stack1.push(i);
                    }
                }
            } else {
                count = 0;
                stack.push(arr[i]);
                while(!stack1.isEmpty()){
                    stack1.pop();
                }

            }
            result = Math.max(count, result);
        }

        System.out.print(Math.max(count, result));
    }
}
