package eu.shiny.WeekOfCode18;

import java.util.Scanner;

/**
 * Created by e1065894 on 26-Nov-15.
 */
public class Target {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        int R[] = new int[K];

        for(int R_i=0; R_i < K; R_i++){
            R[R_i] = in.nextInt();
        }
        int x[][] = new int[N][2];

        for(int x_i=0; x_i < N; x_i++){
            for(int x_j=0; x_j < 2; x_j++){
                x[x_i][x_j] = in.nextInt();
            }
        }

        int score = 0;
        for(int i = 0; i < N; ++i){
            double dist = Math.sqrt(((double)x[i][0] * (double)x[i][0]) + ( (double)x[i][1] * (double)x[i][1]));
            if(dist > R[0]){
                score+= 0;
            }else if(dist <= R[K-1]){
                score+=K;
            }else{
                score += binarySearch(R, dist, 0, K-1) + 1;
            }

        }

        System.out.print(score);
    }

    public static int binarySearch(int[] r, double dist, int start, int end){
        if(end - start <=1 ){
            return start;
        }else{
            int mid = (start  + end)/2;
            if(r[mid] > dist){
                return binarySearch(r, dist, mid, end);
            }else if(r[mid] < dist){
                return binarySearch(r, dist, start, mid);
            }else {
                return mid;
            }
        }
    }
}
