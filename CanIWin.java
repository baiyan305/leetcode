// 464. Can I Win

import java.util.Arrays;
import java.util.HashMap;

public class CanIWin {

    public void run() {
        System.out.println(canIWin(10,11));
        System.out.println(canIWin(20,209));
        System.out.println(canIWin(5,50));

        System.out.println("123");
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int[] state = new int[maxChoosableInteger];
        HashMap<String, Boolean> mem = new HashMap<>();

        // 如果所有数字的总和比desiredTotal小，那么没有胜者，直接返回false就可以了
        if(maxChoosableInteger * (maxChoosableInteger+1)/2 < desiredTotal)
            return false;

        return win(state, 0, desiredTotal, mem);
    }

    // win方法，返回当前状态state下，是否可以有一种玩法，一定赢。
    // 如果确定一定赢呢？
    // 1. 如果从可选的数字中选一个，加上目前的total，比desiredTotal大，那么一定赢的玩法就找到了，返回true。
    // 2. 当前回合的玩家选了一个数字后, 进入下一轮, 如果玩家找不到一种一定赢的方式, 那么当前轮的玩家就赢了。
    //
    // 假设可选10个数字, 1到10, desireTotal先不考虑. 玩家1叫P1, 玩家2叫P2.
    //
    // 递归的第1层是P1选数字
    // 递归的第2层是P2选数字
    // 递归的第3层是P1选数字
    // 递归的第4层是P2选数字
    // ...
    //
    // 来看看递归的结果是如果一层一层返回的
    //
    //
    //    假设有4个数字,A,B,C,D
    //
    //          P1
    //    选A 选B  选C 选D
    //    P2  P2  P2  P2
    //    win win win win   -- P1一定输
    //    win win win lose  -- 如果P1选了D, 那么P2无论选什么都会输, 那么P1选D就一定赢了
    //    上面这种情况, 假设有4个数字, P1可以有4个选择, 之后进入下一轮有4种情况
    //    1.如果4种情况下, P2都能找到一种方式一定赢, 那么P1一定输
    //    2.如果4种情况下, 有一种方式, P2一定会输, 那么P1就找到了一种一定能赢的方式
    private boolean win(int[] state, int total, int desiredTotal, HashMap<String, Boolean> mem) {
        String curState = Arrays.toString(state);
        if(mem.containsKey(curState))
            return mem.get(curState);

        for(int i=0; i<state.length; i++) {
            if(state[i] == 0) {
                // 选择了一个数字后
                // 如果数字加上之前的total, 大于等于desiredTotal, 那么当前状态一定是能赢的
                // 如果之后的玩家, 一定会输, 那么当前状态一定是能赢的
                state[i] = 1;
                // 如果下了一轮的玩家一定会输, 那么当前玩家一定赢了
                if(total + i + 1 >= desiredTotal || !win(state, total + i + 1, desiredTotal, mem)) {
                    mem.put(curState, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }

        // 如果当前的状态下, 无论怎么选, 下一轮的玩家都能找到一种方式一定赢, 那么当前状态一定是输
        mem.put(curState, false);
        return false;
    }

}
