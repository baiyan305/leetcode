// 299. Bulls and Cows

public class BullsAndCows {

    public void run() {
        System.out.println(getHint("1807","7810"));
        System.out.println(getHint("1123","0111"));
    }

    // 题意: 对比secret和guess的每个字符。字符和位置都相同的是bulls，字符相同但是位置不同的是cows。
    //
    // 解法: 循环secret和guess。如果字符相同，bulls++.
    // 如果不同。如果在secret中出现了，那么map中对应的值++, 如果在guess中就减减。这样使用加加减减就可以记录
    // 字符在secret和guess中出现的次数。
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        int[] map = new int[10];
        for(int i=0; i<secret.length(); i++) {
            int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
            if(s == g) bulls++;
            else {
                if (map[s]++ < 0) cows++; // map[s]如果是负值，说明secret的当前字符在guess中出现过
                if (map[g]-- > 0) cows++; // map[g]如果是正值，说过guess的当前字符在secret中出现过
            }
        }

        return bulls+"A"+cows+"B";
    }

}
