// 795. Number of Subarrays with Bounded Maximum

public class NumberOfSubarrayWithBoundedMaximum {

    public static void main(String[] args) {
        //int[] A = {2, 9, 2, 5, 6};
        int[] A = {16,69,88,85,79,87,37,33,39,34};
        System.out.println(numSubarrayBoundedMax(A, 55, 57));
    }

    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0 , left = 0 , right = -1;

        for(int i=0; i < A.length; i++) {
            if(A[i] > R) {
                left = i+1;
                right = i;
            } else if( L <= A[i] && A[i] <= R) {
                right = i;
                count += right - left + 1;
            } else {
                count += right - left + 1;
            }
        }

        return count;
    }

}