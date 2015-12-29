package eu.shiny.queueproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by e1065894 on 24-Nov-15.
 */
public class TruckTour {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Queue<Pump> queue = new LinkedList<Pump>();

        for(int i = 0; i < n; ++i){
            Pump pump = new Pump();
            pump.petrol = in.nextInt();
            pump.distance = in.nextInt();
            pump.index = i;

            queue.offer(pump);
        }

        int diff = 0;
        int result = 0;

        while(!queue.isEmpty()){
            Pump pump = queue.poll();
            diff = diff + pump.petrol - pump.distance;

            if(diff<0){
                diff =  0;
                result = queue.peek().index ;
            }
        }

        System.out.print(result);
    }

    public static class Pump{

        public int index;
        public int petrol;
        public int distance;

    }
}
