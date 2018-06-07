// 370. Range Addition

public class RangeAddition {

    public static void main(String[] args) {
        int[][] updates = {
                {1,3,2},
                {2,4,3},
                {0,2,-2}
        };

        int[] arr = getModifiedArray(5, updates);

        for(int num : arr) System.out.print(num + ", ");
    }

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for(int[] update : updates) {
            array[update[0]] += update[2];
            if(update[1]+1<length) array[update[1]+1] -= update[2];
        }

        int sum = 0;
        for(int i=0; i<length; i++) {
            int tmp = array[i];
            array[i] += sum;
            sum += tmp;
        }

        return array;
    }

}