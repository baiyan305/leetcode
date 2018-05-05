// 368. Largest Divisible Subset

public class LargestDivisibleSubset {

    public static void main(String[] args) {

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums==null || nums.length==0) return list;

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.sort(list);
        
        int max = 1, maxIdx = 0;
        for(int i=0; i<len; i++) {
            for(int j=i-1; j>=0; i++) {
                if(nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(dp[i] > max) maxIdx = i;
        }

        
    }

}