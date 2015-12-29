package eu.shiny.Textkernel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prime {

    public void printPrimeNumbers(int num1, int num2){

        int start = num1 < num2 ? num1 : num2;
        int end = num1 < num2 ? num2 : num1;

        for(int i = start; i <= end; ++i){
            if(isPrimeNumber(i)){
                System.out.println(i);
                //if a number is prime, next number can not be prime
                ++i;
            }
        }

    }

    public void printPrimeNumbersByLimitedCPUCores(final int num1, final int num2, int cpus){

        ExecutorService executor = Executors.newFixedThreadPool(cpus);

        executor.execute(new Runnable() {
            public void run() {
                printPrimeNumbers(num1, num2);
            }
        });
    }


    private boolean isPrimeNumber(int i) {
        if(i < 0) {
            i = -1 * i;
        }

        if(i % 2 == 0){
            return  false;
        }

        for(int j = 3; i >= j*j; j+=2 ){
            if(i % j == 0) return false;
        }

        return true;
    }

}
