public class Solution {
	
	
	public static int[] numbers = {5,1,-2, 4,-3,8, 22, 0, -7, -1, 78};
	private int[] helper;
	
	public static void main(String[] args){
	    Solution solution = new Solution();
	    solution.printArray();
	    
		System.out.println("After sorting the array");
//		solution.insertionsort(numbers);
//		solution.quicksort(0, numbers.length - 1);
//		solution.selectionSort(numbers);
//		solution.bubleSort(numbers);
//		solution.shellShort(numbers);
//		solution.arrangeArray(numbers);
		solution.mergeSortMain(numbers);
		solution.printArray();
		
	}
	
	private void printArray(){
	    System.out.println("------------------------");
        for(int i : numbers){
            System.out.print(i + " |" );
        }
        System.out.println("\n------------------------");
	}
	
	 private void quicksort(int low, int high) {
		    int i = low, j = high;
		    // Get the pivot element from the middle of the list
		    int pivot = numbers[low + (high-low)/2];

		    // Divide into two lists
		    while (i <= j) {
		      // If the current value from the left list is smaller then the pivot
		      // element then get the next element from the left list
		      while (numbers[i] < pivot) {
		        i++;
		      }
		      // If the current value from the right list is larger then the pivot
		      // element then get the next element from the right list
		      while (numbers[j] > pivot) {
		        j--;
		      }

		      // If we have found a values in the left list which is larger then
		      // the pivot element and if we have found a value in the right list
		      // which is smaller then the pivot element then we exchange the
		      // values.
		      // As we are done we can increase i and j
		      if (i <= j) {
		        exchange(i, j);
		        i++;
		        j--;
		      }
		    }
		    // Recursion
		    if (low < j)
		      quicksort(low, j);
		    if (i < high)
		      quicksort(i, high);
		  }
	 
	 private void insertionsort(int[] arr){
	     
	     for(int i = 1; i < arr.length ; ++i){
	         for(int j = i ; j>0 ; --j){
	             if(arr[j] < arr[j-1]){
	                 exchange(j, j-1);
	             }
	         }
	     }
	 }
	 
//	 private void shellSort(int[] arr){
//	     int interval = arr.length/2;
//	     while (interval > 0) {
//             for (int i = interval; i < arr.length; i++) {
//                 int j = i;
//                 while (j >= interval && arr[j - interval] > arr[j]) {
//                     exchange(j, j - interval);
//                     j = j - interval;
//                 }
//             }
//             if (interval == 2) {
//                 interval = 1;
//             } else {
//                 interval *= (5.0 / 11);
//             }
//         }
//	     
//	     }
	 
	 private void selectionSort(int[] arr){
	     for(int k = 0; k < arr.length; ++k){
	         int min = k;
	         for(int i = k + 1 ; i < arr.length ; ++i){
	             if(arr[min] > arr[i]){
	                 min = i;
	             }
	         }
	         exchange(k, min);
	     }
	 }
	 
	 private void bubleSort(int[] arr){
	     for(int i = arr.length ; i >=0 ; --i){
	         for(int j = 0 ; j<i-1 ; ++j){
	             if(arr[j] > arr[j+1]){
	                 exchange(j, j+1);
	             }
	         }
	         printArray();
	     }
	 }
	 
	 private void shellShort(int[] arr){
	     int interval = arr.length / 2;
	     while(interval > 0){
	         for(int i = interval ; i < arr.length ; ++i){
	             for(int j = i ; j >=interval ; j-=interval){
	                 if(arr[j] < arr[j - interval]){
	                     exchange(j, j - interval);
	                 }
	             }
	         }
             if (interval == 2) {
                 interval = 1;
             } else {
                 interval *= (5.0 / 11);
             }
	     }
	 }
	 
	 public void mergeSortMain(int[] values) {
	     this.helper = new int[values.length];
	     mergesort(0, values.length - 1);
	   }

	   private void mergesort(int low, int high) {
	     // check if low is smaller then high, if not then the array is sorted
	     if (low < high) {
	       // Get the index of the element which is in the middle
	       int middle = low + (high - low) / 2;
	       // Sort the left side of the array
	       mergesort(low, middle);
	       // Sort the right side of the array
	       mergesort(middle + 1, high);
	       // Combine them both
	       merge(low, middle, high);
	     }
	   }

	   private void merge(int low, int middle, int high) {

	     // Copy both parts into the helper array
	     for (int i = low; i <= high; i++) {
	       helper[i] = numbers[i];
	     }

	     int i = low;
	     int j = middle + 1;
	     int k = low;
	     // Copy the smallest values from either the left or the right side back
	     // to the original array
	     while (i <= middle && j <= high) {
	       if (helper[i] <= helper[j]) {
	         numbers[k] = helper[i];
	         i++;
	       } else {
	         numbers[k] = helper[j];
	         j++;
	       }
	       k++;
	     }
	     // Copy the rest of the left side of the array into the target array
	     while (i <= middle) {
	       numbers[k] = helper[i];
	       k++;
	       i++;
	     }

	   }
	 
	 public void arrangeArray(int[] arr){
	        for(int j = arr.length; j>0 ; --j){
	            for(int i = 1; i<j; ++i){
	                if(arr[i] < 0 && arr[i - 1] >= 0){
	                    int temp = arr[i-1];
	                    arr[i-1] = arr[i];
	                    arr[i] = temp;
	                }
	                if(arr[i] == 0 && arr[i - 1] > 0){
                        int temp = arr[i-1];
                        arr[i-1] = arr[i];
                        arr[i] = temp;
                    }
	            }
	        }
	        
	    }
	 
	  private void exchange(int i, int j) {
	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	  }

}
