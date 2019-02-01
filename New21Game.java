// 837. New 21 Game

public class New21Game {

    public void run() {
        System.out.println(new21Game(10,1,10));
        System.out.println(new21Game(6,1,10));
        System.out.println(new21Game(21,17,10));
        System.out.println("123");
    }

    // 改进DP
    // 思路是前缀和
    // 我们每次求一个数字X的概率时, 是求下面序列的和
    // dp[X-1]/W + dp[X-2]/W + dp[X-3]/W ... + dp[X-W]/W, 等于
    // (dp[X-1]+dp[X-2]+dp[X-3]...+dp[X-W])/W
    //
    // 这里dp[i]表示最后到达i的概率, 我们改一下, 改成到达0-i所有数字的概率和
    // 那么i的概率可以改成 sum[i-1] - sum[i-W-1]
    // 时间复杂度从O(N*k)变成O(N)
    public double new21Game(int N, int K, int W) {
        double[] sum = new double[N+1];
        sum[0] = 1;

        for(int i=1; i<=N; i++) {
            sum[i] = sum[i-1];
            if(i <= W)
                sum[i] += sum[i-1]/W;
            else
                sum[i] += (sum[i-1] - sum[i-W-1])/W;
            if(i > K)
                sum[i] -= (sum[i-1]-sum[K-1])/W;
        }

        return sum[N] - sum[K-1];
    }

    /* O(N*K)做法
    最基础的DP, 举个例子吧
    比如可选卡片是1-10, K是20, N是25

    对于数字0, 我们认为它的概率是1
    对于数字1, 只有一种可能到1, 就是从0开始, 抽一张1, 0+1就是1了. 抽出1的概率是1/10, 所以1的概率是0.1
    对于数字2, 0+2, 概率是0.1, 1+1, 概率是0.1*0.1, 所以2的概率是0.11
    对于数字3, 0+3, 概率是0.1, 1+2, 概率是0.1*0.1, 2+1, 概率是0.11*0.1, 所以3的概率是0.1+0.11+0.0111

    有一种情况, 对于数字13, 加入K是10, N是15, 那么不用考虑11,12到13的概率, 因为题目说了大于等于K就停了

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N+1];
        dp[0] = 1;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=W; j++) {
                //i-j<K是什么意思呢, i-j是起点, 起点不能大于等于K, 因为题目说了大于等于K就停了
                if(i-j>=0 && i-j < K) {
                    dp[i] += dp[i-j]/W;
                }
            }
        }

        double res = 0;
        for(int i=K; i<=N; i++) {
            res += dp[i];
        }

        return res;
    }
    */

}
