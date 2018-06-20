// 769. Max Chunks To Make Sorted

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{0,1,2,3,4,5}));
        System.out.println(maxChunksToSorted(new int[]{5,4,3,2,1,0}));
        System.out.println(maxChunksToSorted(new int[]{0,1,2,3,5,6,7,4}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int chunk = 0, value = 0;

        for(int i=0; i<arr.length; i++) {
            value = Math.max(value, arr[i]);
            if(value == i) chunk++;
        }

        return chunk;
    }

}