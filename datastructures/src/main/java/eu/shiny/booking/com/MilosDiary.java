package eu.shiny.booking.com;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mukulagrawal on 2/20/16.
 */
public class MilosDiary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        boolean result = true;
        int lasteligible = 0;

        found:
        while(m > 0){
            int num = in.nextInt();
            if(stack.isEmpty()){
                stack.push(num);
                lasteligible = num -1;

            }else if(num > stack.peek()){
                lasteligible = num -1;

                while(stack.peek() == lasteligible){
                    stack.pop();
                    --lasteligible;
                }

//                while(stack.search(lasteligible) != -1){
//                    --lasteligible;
//                }
                stack.push(num);
            }else {
                if(num == lasteligible){
                    //stack.push(num);
                    --lasteligible;
//                    while(stack.peek() == lasteligible){
//                        stack.pop();
//                        --lasteligible;
//                    }

                    while(stack.search(lasteligible) != -1){
                        lasteligible--;
                    }
                    stack.push(num);

                }else{
                    result = false;
                    break found;
                }
            }

            --m;
        }

        System.out.println(result ? "YES" : "NO");
    }
}
