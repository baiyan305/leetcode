// 948. Bag of Tokens

public class BagOfTokens {

    // 题意有点复杂
    // 有一堆token, 怎么翻译呢，有点像赌场的筹码
    // 然后你有一个初始的能量
    //
    // 能量和筹码可以互换
    // 每次用能量换筹码时，point加1
    // 每次用point换筹码时，能量增加
    // 求最后能得到的最大point
    //
    // 解法是贪心
    //
    // 当还有能量时，尝试去换筹码来加point，换的原则是，去换最小的token,这样代价最小
    // 当能量不够换最小的筹码时，有两种情况
    //    1. 还有point，可以用point换筹码来增加能量，原则肯定是换最大的筹码，这样收获的能量最多
    //    2. 没有point, 游戏结束
    //
    // 所以第一步先将tokens排序
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        // 当需要用P换token挣point时, 用最小的代价买token，就是换最小的那个token
        // 当需要用point换token来换P时，用point换来最大的token, 就是换最大的那个token
        int up = 0, down = tokens.length-1, point = 0, max = 0;
        while(up <= down) {
            // 手头的P还能买最小的那个token
            if(P >= tokens[up]) {
                P -= tokens[up++];
                point++;
                max = Math.max(max, point);
            }
            // 手头的P连最小的那个token都买不起, 但是还有point可以换大token
            else if(point > 0){
                P += tokens[down--];
                point--;
                max = Math.max(max, point);
            }
            // 手头的P连最小的那个token都买不起, 并且没有point换大token了, 玩不下去了
            else {
                break;
            }
        }

        return max;
    }

}
