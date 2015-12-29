package eu.shiny.algorithms;

import java.util.Scanner;

/**
 * Created by e1065894 on 22-Dec-15.
 */
public class MatrixRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();

        int[][] arr = new int[m][n];
        for(int i = 0; i <m; ++i){
            for(int j = 0; j < n; ++j){
                arr[i][j] = in.nextInt();
            }
        }
        int i_s = 0;
        int i_e = m-1;
        int j_s = 0;
        int j_e = n-1;

        while(i_e > i_s && j_e > j_s){
            //rotation of single block
            int peri = (i_e - i_s + 1)* 2 + (j_e - j_s - 1)*2;
            int rotation = r % peri;
//            int[] temp = new int[peri];
            int a = i_s;
            int b = j_s;

            //fill the temp array with rotated element
            LinkListLight list = new LinkListLight();
            for(int k = 0; k < peri; ++k){
                list.insert(arr[a][b]);
//                temp[(k + rotation) % peri] = arr[a][b];
                if(a == i_s && b < j_e){
                    ++b;
                }else if( b == j_e && a < i_e ){
                    ++a;
                }else if(a == i_e && b > j_s){
                    --b;
                }else if(b == j_s && a > i_s){
                    --a;
                }

            }

            list.rotateBy(rotation);

            //place the element form temp array back
            int x = i_s;
            int y = j_s;

            Node node = list.head;

            for(int j = 0; j < peri; ++j){
//                arr[x][y] = temp[j];
                arr[x][y] = node.val;
                if(x == i_s && y < j_e){
                    ++y;
                }else if(y == j_e && x < i_e){
                    ++x;
                }else if(x == i_e && y > j_s){
                    --y;
                }else if(y == j_s && x > i_s){
                    --x;
                }
                node = node.next;
            }

            i_s++;
            j_s++;
            i_e--;
            j_e--;

        }

        for(int g = 0; g < m; ++g){
            for(int h = 0; h < n; ++h){
                System.out.print(arr[g][h] + " ");
            }
            System.out.println();
        }

    }

    public static class LinkListLight{
        public Node head;
        public Node tail;

        public void insert(int value){
            Node node = new Node();
            node.val = value;

            if(head == null && tail == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
        }

        public void rotateBy(int num){
            while (num > 0){
                Node currHead = this.head;
                this.head = this.head.next;
                tail.next = currHead;
                tail = currHead;
                --num;
            }
        }

    }

    public static class Node{
        public int val;
        public Node next;

    }


}
