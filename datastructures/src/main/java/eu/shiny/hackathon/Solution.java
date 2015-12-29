package eu.shiny.hackathon;

//public class Solution {
//
////    public static void main(String[] args) {
////        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
////        Scanner in = new Scanner(System.in);
////        int t = in.nextInt();
////        int total = t;
////        float _p = 0;
////        float _n = 0;
////        float _z = 0;
////
////        while(t > 0){
////            int temp = in.nextInt();
////            if(temp < 0) _n++;
////            else if(temp > 0) _p++;
////            else if (temp == 0) _z++;
////            --t;
////        }
////
////        System.out.printf("%.3f", _p/total);
////        System.out.println();
////        System.out.printf("%.3f", _n/total);
////        System.out.println();
////        System.out.printf("%.3f", _z/total);
////
////
////    }
//
////    public static void main(String[] args) {
////        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
////        Scanner in = new Scanner(System.in);
////
////        int _t = in.nextInt();
////
////        while(_t > 0){
////            int s = in.nextInt();
////            int e = in.nextInt();
////            int c = 0;
////
////            int i = s > 0 ? s: 0 ;
////             e = e > 0 ? e : 0;
////
////            while(i<=e){
////                int sqrt = (int) Math.sqrt(i);
////                if(sqrt * sqrt == i) {
////                    c++;
////                }
////                i = (sqrt+1)*(sqrt+1);
////            }
////            System.out.println(c);
////            _t--;
////        }
////    }
//
////    public static void main(String[] args) {
////        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
////        Scanner in = new Scanner(System.in);
////
////        int _t = in.nextInt();
////        while(_t > 0){
////            int d = in.nextInt();
////            int x = 0;
////            int y = 0;
////
////            while( ((d - (5*x))/3) >0){
////                if((d - (5*x)) % 3 == 0){
////                    y = (d - (5*x))/3 ;
////                    break;
////                }
////                ++x;
////            }
////
////            if((x== 0 && y == 0) || ((5 * x) + (3*y)) != d){
////                System.out.println(-1);
////                --_t;
////                continue;
////            }
////
////            StringBuffer num = new StringBuffer();
////            y = 3*y;
////            x = x*5;
////
////            while(y>0){
////                num.append("5");
////                --y;
////            }
////            while(x>0){
////                num.append("3");
////                --x;
////            }
////            //now its a series
////            System.out.println(num.toString());
////            --_t;
////        }
////    }
//
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        boolean exit = false;
////
////        while(!exit){
////            int n = Integer.parseInt(in.nextLine());
////
////            if(n == 0){
////                exit = true;
////                continue;
////            }else{
////                int[][] wayyard = new int[n][];
////                int maxBenifit = 0;
////                int[] maxMatr = new int[n];
////
////                for(int j = 0; j < n ; ++j){
////                    int z = in.nextInt();
////                    wayyard[j] = new int[z];
////                    int profit = 0;
////                    int max = 0;
////
////                    for(int i = 0; i < z ; ++i){
////                        profit = profit + 10 - in.nextInt() ;
////                        wayyard[j][i] = profit;
////
////                        if(profit >= max){
////                            max = profit;
////                        }
////                    }
////
////                    maxMatr[j] = max;
////                    maxBenifit = maxBenifit + max;
////
////                }
////                calculateMaximumBennifit(wayyard, maxMatr, maxBenifit);
////
////            }
////
////        }
////    }
//
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        int cities = in.nextInt();
////       int budget = in.nextInt();
////       double[][][] matrix = new double[cities][][];
////       double max = 0;
////
////       for(int i = 0; i < cities; ++i){
////           int opt = in.nextInt();
////
////           double[][] mat = new double[opt][2] ;
////           for(int j = 0; j < opt; ++j){
////               mat[j][0] = in.nextInt();
////               mat[j][1] = in.nextDouble();
////           }
////
////           matrix[i] = mat;
////
////       }
////
////       for(int j = 0; j < matrix.length -1 ; ++j){
////           double maxLocal = 0;
////           int costLocal = 0;
////           for(int k = 0; k < matrix[j].length; ++k){
////               double t1 = matrix[j][k][1];
////               double cost = matrix[j][k][0];
////
////               for(int m = 0; m < matrix[j +1].length; ++m){
////                   double sum = t1 + matrix[j+1][m][1];
////                   int sumCost = (int) (cost + matrix[j+1][m][0]);
////
////                   if(sum > maxLocal && sumCost <=budget){
////                       maxLocal = sum;
////                       costLocal = sumCost;
////                   }
////
////               }
////
////           }
////           if(j == 0){j++;}
////           max = max + maxLocal;
////           budget = budget - costLocal;
////           if(budget < 0) {
////               max = -1;
////               break;
////           }
////       }
////
////       System.out.printf("%.2f", max);
////
////    }
////
//
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        int t = in.nextInt();
////
////        int rect = 0;
////        int square = 0;
////        int polygons = 0;
////
////        while(t > 0){
////            int d1= in.nextInt();
////            int d2 = in.nextInt();
////            int d3 = in.nextInt();
////            int d4 = in.nextInt();
////
////            if(d1 == d2 && d2 == d3 && d3 == d4 ){
////                square++;
////            }else if(d1 == d3 && d2 == d4 && d1 != d2){
////                rect++;
////            }else if(d1 != 0 && d2 != 0 && d3 != 0 && d4 != 0) {
////                polygons++;
////            }
////
////            --t;
////        }
////
////        System.out.print(square + " " + rect + " " + polygons );
////
////    }
//
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////
////        List<String> list = new ArrayList<String>();
////        List<String> match = new ArrayList<String>();
////
////        while(in.hasNextLine()){
////            list.add(in.nextLine());
////        }
////
////
////
////    }
//
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////
////        StringBuffer buff = new StringBuffer();
////        String token = "-128";
////
////        int t1 = in.nextInt();
////        buff.append(t1);
////
////        while(in.hasNextInt()){
////            int t2 = in.nextInt();
////            int diff = t2 -t1;
////
////            if(diff < -127 || diff > 127){
////                buff.append(" -128 " + diff );
////            }else{
////                buff.append(" " + diff);
////            }
////            t1 = t2;
////        }
////
////        System.out.println(buff.toString());
////    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        List<String> list = new ArrayList<String>();
//        List<String> match = new ArrayList<String>();
//
//        while(in.hasNextLine()){
//            list.add(in.nextLine());
//        }
//
//        Collections.sort(list);
//        for(int i = 0; i < list.size() -2 ; ++i){
//            StringBuffer buff = new StringBuffer(list.get(i));
//            for(int j = i + 1 ;  j < list.size(); ++j){
//                if(areAnagram(list.get(i), list.get(j))){
//                    buff.append("," + list.get(j));
//                    list.add(j, "");
//                }
//            }
//            match.add(buff.toString());
//        }
//        Collections.sort(match);
//        for(String str : match){
//            System.out.println(str);
//        }
//
//    }
//
//    public static boolean areAnagram(String w1, String w2) {
//        char[] word1 = w1.replaceAll("[\\s]", "").toCharArray();
//        char[] word2 = w2.replaceAll("[\\s]", "").toCharArray();
//        Arrays.sort(word1);
//        Arrays.sort(word2);
//        return Arrays.equals(word1, word2);
//   }
//    private static void calculateMaximumBennifit(int[][] wayyard, int[] maxMatr, int maxBenifit) {
//        int waywardNum = wayyard.length;
//        List<Integer> prules = new ArrayList<Integer>();
//
//        for(int i = 0; i < wayyard.length ; ++i){
//
//            for(int j = 0; j < wayyard[i].length ; ++j){
//
//            }
//        }
//    }
//
//
//}


public class Solution {



    public static void main(String[] args) throws Throwable {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

//        Scanner in = new Scanner(System.in);
//        int l = Integer.parseInt(in.nextLine());
//        Trie trie = new Trie();
//        while(l > 0){
//            String input = in.nextLine();
//            if(trie.hasPrefix(input)){
//                System.out.println("BAD SET");
//                System.out.println(input);
//                return;
//            }else{
//                trie.insert(input);
//            }
//
//            --l;
//        }
//        System.out.println("GOOD SET");

        try {
            while (true) {
                try {

                    try {
                        break;
                    }finally {

                        throw new Exception("show it");
                    }
                } catch (Exception ex1) {
                    System.out.print("in exception 1");
                }
            }

        }catch (Exception ex2){
            System.out.print("in exception 2");
        }
    }


    public static class Trie{
        public Node root = new Node();

        public void insert(String val){
            root.insert(val);
        }

        public boolean hasPrefix(String val){
            return root.hasPrefix(val);
        }

        public static class Node{

            public Node[] nodes = new Node[26];

            public boolean hasWord = false;

            public void insert(String value){
                int charAt = value.charAt(0) - 97;

                if(nodes[charAt] == null){
                    nodes[charAt] = new Node();
                    if(value.length() == 1){
                        nodes[charAt].hasWord = true;
                    }
                }

                if(value.length() > 1){
                    nodes[charAt].insert(value.substring(1));
                }

            }


            public boolean hasPrefix(String val){
                int charAt = val.charAt(0) - 97;
                if(nodes[charAt] == null){
                    return false;
                }else{
                    if(nodes[charAt].hasWord){
                        return true;
                    }else{
                        if(val.length() > 1){
                            return nodes[charAt].hasPrefix(val.substring(1));
                        }else{
                            return true;
                        }
                    }

                }
            }

        }

    }

}