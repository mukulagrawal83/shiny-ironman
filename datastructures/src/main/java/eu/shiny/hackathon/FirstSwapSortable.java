package eu.shiny.hackathon;

public class FirstSwapSortable {
    
    public static void main(String[] args) {
        
      System.out.println("is array sortable with first swap :" + Boolean.toString(solution(new int[]{1,20,3,4,5,6,7,8,9,2})));
  }
    
    public static boolean solution(int[] A) {
        // write your code in Java SE 8
        int firstCandidateIndex = -1;
        int secondCandidateIndex = -1;
        boolean isFirstFound = false;
        boolean isSecondFound = false;
        int temp = 0; 
        
        for(int i = 1; i < A.length; ++i){
            if(A[i -1] > A[i] && !isFirstFound){
                temp = A[i-1];
                firstCandidateIndex = i -1;
                isFirstFound = true;
            }
            
            //if first swap index is found, go for second one
            if(isFirstFound){
                if(A[i] >= A[firstCandidateIndex -1] && A[i] <= A[firstCandidateIndex + 1]){
                    secondCandidateIndex = i;
                    isSecondFound = true;
                }
            }
            
        }
        //swap now
        if(isFirstFound && isSecondFound){
            A[firstCandidateIndex] = A[secondCandidateIndex];
            A[secondCandidateIndex] = temp;
        }
        
         //return true if array is sorted
        for(int j=0 ; j < A.length -1 ; ++j){
            if(A[j] > A[j + 1]){
                return false;
            }
        }
        return true;
    }
}
