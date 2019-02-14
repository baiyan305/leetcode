// 640. Solve the Equation

public class SolveTheEquation {

    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] count0 = getCount(strs[0]);
        int[] count1 = getCount(strs[1]);

        int countOfX = count0[0] - count1[0];
        int countOfNum = count1[1] - count0[1];

        if(countOfX == 0 && countOfNum == 0)
            return "Infinite solutions";
        if(countOfX == 0 && countOfNum != 0)
            return "No solution";

        return "x="+String.valueOf(countOfNum/countOfX);
    }

    // int[0]是X数量
    // int[1]是数字数量
    private int[] getCount(String str) {
        int numOfX = 0, numOfNum = 0, sign = 1, num = 0;

        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if(c == 'x') {
                // 遇到X, 就是要累加numOfX
                // 下面的是edge case, 比如x是开头第一个或者
                // x前面没有数字, 比如1+x
                // 那么num虽然是0, 其实是1
                if(i==0 || !Character.isDigit(chars[i-1]))
                    num = 1;
                numOfX += sign * num;

                // reset num
                num = 0;
            } else if(c == '+' || c == '-') {
                // 如果第一个就是+-号，不需要更新数字
                if(i > 0) {
                    // 如果+-号前面的不是X, 前面一定是数字
                    if(i-1>= 0 && chars[i-1] != 'X')
                        numOfNum += sign * num;
                }

                // 更新sign
                sign = c == '+' ? 1 : -1;

                // reset num
                num = 0;
            }
        }

        // 最后还是要更新一下
        if(chars[chars.length-1] == 'X') {
            numOfX += sign * num;
        } else {
            numOfNum += sign * num;
        }

        return new int[]{numOfX, numOfNum};
    }

}
