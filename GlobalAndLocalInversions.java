// 775. Global and Local Inversions

public class GlobalAndLocalInversions {

    public static void main(String[] args) {
        System.out.println(isIdealPermutation(new int[]{1,0,2}));
        System.out.println(isIdealPermutation(new int[]{1,2,0}));
        System.out.println(isIdealPermutation(new int[]{1,2,0,3}));
    }

    public static boolean isIdealPermutation(int[] A) {
        int min = A[A.length-1];
        for(int i=A.length-1; i>=2; i--) {
            min = Math.min(min, A[i]);

            if(A[i-2] > min) return false;
        }

        return true;
    }

}