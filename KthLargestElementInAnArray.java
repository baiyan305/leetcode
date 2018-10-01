// 215. Kth Largest Element in an Array

import java.util.Random;

public class KthLargestElementInAnArray {

    public void run() {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));

        //int[] nums = {3,2,3,1,2,4,5,5,6};
        //System.out.println(findKthLargest(nums,4));

        System.out.println("123");
    }

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return findKthLargest(nums, 0, nums.length-1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        swap(nums, start, end);

        int pivot = nums[end], replaceIdx = start;
        for(int i=start; i<end; i++) {
            if(nums[i] >= pivot) {
                swap(nums, replaceIdx, i);
                replaceIdx++;
            }
        }

        swap(nums, replaceIdx, end);

        int leftCount = replaceIdx - start + 1;
        if (leftCount == k) {
            return nums[replaceIdx];
        } else if(leftCount > k) {
            return findKthLargest(nums, start, replaceIdx-1, k);
        } else {
            return findKthLargest(nums, replaceIdx+1, end, k-leftCount);
        }
    }

    private void swap(int[] nums, int start, int end) {
        int backup = nums[start];
        nums[start] = nums[end];
        nums[end] = backup;
    }

    private void shuffle(int[] a){
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    /*
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int start = 0, end = nums.length-1;
        while(start < end) {
            int idx = partition(nums, start, end);
            if(idx+1 > k) end = idx - 1;
            else if(idx+1 < k) start = idx + 1;
            else return nums[idx];
        }
        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        swap(nums, start, end);

        int pivot = nums[end], replaceIdx = start;
        for(int i=start; i<end; i++) {
            if(nums[i] > pivot) {
                swap(nums, replaceIdx, i);
                replaceIdx++;
            }
        }
        swap(nums, replaceIdx, end);

        return replaceIdx;
    }

    private void swap(int[] nums, int start, int end) {
        int backup = nums[start];
        nums[start] = nums[end];
        nums[end] = backup;
    }

    void shuffle(int[] a){
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
    */

}
