// 494. Target Sum

public class TargetSum {

    public void run() {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        //System.out.println(findTargetSumWays(new int[]{1}, 2147483647));
        //System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

    // 还有一种更简单的方法, 就是将这个问题转化为一个找子数组和的方法.
    // 原题的意思是说，将数组中的元素，一些取正，一些取负，他们的和等于target.
    // 那么所有取正的数字定义为P, 所有取负的定义为N.
    //                   sum(P) - sum(N) = target
    // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                   2 * sum(P) = target + sum(nums)
    // sum(P) = (target + sum(nums)) / 2
    // 其实就是找子数组的个数, 子数组的和为 (target + sum(nums)) / 2

    // 一维DP
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return S == 0 ? 1 : 0;

        int sum = 0;
        for(int num : nums) sum += num;
        int[] dp = new int[sum*2+1];

        int num0 = nums[0];
        for(int i=0; i<dp.length; i++) {
            if(num0 == i-sum) dp[i] += 1;
            if(-num0 == i-sum) dp[i] += 1;
        }

        for(int j = 1; j < nums.length; j++) {
            int num = nums[j];
            int[] tmp = new int[dp.length];
            for(int i = 0; i < tmp.length; i++) {
                if(i-sum+num <= sum) tmp[i] += dp[i+num];
                if(i-sum-num >= -sum) tmp[i] += dp[i-num];
            }
            dp = tmp;
        }

        return (long)S+sum < dp.length ? dp[S+sum] : 0;
    }

    /* DFS + Memorization
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, new HashMap<>());
    }

    private int dfs(int[] nums, int idx, int S, HashMap<String, Integer> mem) {
        if(idx >= nums.length) {
            return S == 0 ? 1 : 0;
        }

        String key = idx + ":" + S;
        if(mem.containsKey(key)) return mem.get(key);

        int sPlus = dfs(nums, idx+1, S - 1 * nums[idx], mem);
        int sMinus = dfs(nums, idx+1, S - -1 * nums[idx], mem);

        mem.put(key, sPlus + sMinus);
        return mem.get(key);
    }
    */

}