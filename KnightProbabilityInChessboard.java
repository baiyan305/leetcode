// 688. Knight Probability in Chessboard

public KnightProbabilityInChessboard {

    // DP解法
    // 先算 0 Move情况下的可能性，就是起始位置为1.0，其它位置都为0
    // 然后 1 Move情况下，遍历棋盘的每个位置，对于每个位置x，可以从8个位置到达x
    // 看这8个位置0 Move的情况下有多少可能性可以到达，之后每个位置的可能性在除以8，之后相加

    // 比如我们要求移动8次后，有多少概率还留在棋盘内，其实是可以根据移动7次的结果来得出的。
    // 比如对于位置[3,4]，有8个位置可以达到[3,4]，当然有的位置在棋盘外面，就不用考虑了。
    // 比如能到达[3,4]的位置有，[1,5],[1,3],[5,5],[5,3]等等。求出这些位置移动7次到达他们的概率
    // 比如移动7次到达[1,5]的概率是0.8，除以8得到0.1，累加到[3,4]的结果上
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;

        int[] dx = {-2,-2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};

        while(K-- > 0) {
            double[][] bak = new double[N][N];
            for(int y=0; y<N; y++) {
                for(int x=0; x<N; x++) {
                    for(int i=0; i<8; i++)
                        if(y+dy[i]>=0 && x+dx[i]>=0 && y+dy[i]<N && x+dx[i]<N)
                            bak[y][x] += (dp[y+dy[i]][x+dx[i]]/8);
                }
            }

            dp = bak;
        }

        double total = 0;
        for(double[] row : dp)
            for(double x : row)
                total += x;

        return total;
    }

}
