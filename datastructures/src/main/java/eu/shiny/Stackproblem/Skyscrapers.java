package eu.shiny.Stackproblem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by e1065894 on 06-Dec-15.
 */
public class Skyscrapers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in =  new Scanner(System.in);

        int n = in.nextInt();
        long result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap();

        int last = 0;
        int count = 1;
        for(int i = 0; i<n; ++i){
            int val = in.nextInt();
            if(stack.isEmpty() || val < stack.peek()){
                stack.push(val);
            } else {
                if(val > stack.peek()){
                    Iterator<Integer> integers = map.keySet().iterator();
                    while (integers.hasNext()){
                        Integer next = integers.next();
                        if(next < val){
                            integers.remove();
                        }
                    }
                }

                while(!stack.isEmpty() &&  val > stack.peek()){
                    stack.pop();
                }

                if(!stack.isEmpty() && stack.peek() == val){
                    if(map.get(val) != null){
                        result += map.get(val);
                        map.put(val, map.get(val) + 1);
                    }else {
                        map.put(val, 2);
                        result++;
                    }
                } else{
                    stack.push(val);
                }


            }

        }


        System.out.print(2*result);

    }
}
