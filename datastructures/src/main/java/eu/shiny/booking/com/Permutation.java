package eu.shiny.booking.com;

/**
 * Created by mukulagrawal on 2/20/16.
 */
public class Permutation {

    void printArray(int []a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");

        }
        System.out.println("");
    }
    void permute(int []a,int k ) {
        if(k==a.length)
            printArray(a);
        else
            for (int i = k; i < a.length; i++) {
            int temp=a[k];
            a[k]=a[i];
            a[i]=temp;
            permute(a,k+1);
            temp=a[k];
            a[k]=a[i];
            a[i]=temp;
        }
    }

    public static void printAllSubsets(int[] arr) {
        byte[] counter = new byte[arr.length];

        while (true) {
            // Print combination
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] != 0)
                    System.out.print(arr[i] + " ");
            }
            System.out.println();

            // Increment counter
            int i = 0;
            while (i < counter.length && counter[i] == 1)
                counter[i++] = 0;
            if (i == counter.length)
                break;
            counter[i] = 1;
        }
    }


    public static void main(String[] args) {
//        Permutation p=new Permutation();
        int a[]={3,2,6};

//        p.permute(a, 0);
            printAllSubsets(a);
    }
}
