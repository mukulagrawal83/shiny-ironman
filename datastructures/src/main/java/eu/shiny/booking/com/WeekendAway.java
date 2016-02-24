package eu.shiny.booking.com;

import java.util.Scanner;

/**
 * Created by mukulagrawal on 2/20/16.
 */
public class WeekendAway {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0){
            int result = 0;
            int n = in.nextInt();
            int m = in.nextInt();

            int[] from = new int[m];
            int[] to= new int[m];
            int[] dist = new int[m];

            for(int i = 0; i < m; ++i){
                from[i] = in.nextInt();
                to[i] = in.nextInt();
                dist[i] = in.nextInt();
            }



            --t;
            System.out.println(result);
        }
    }


    public static class Edge {
        int from;
        int to;
        int dist;

        Edge(int from,  int tp, int dist){
            this.dist = dist;
            this.from = from;
            this.to = to;

        }

    }

}

