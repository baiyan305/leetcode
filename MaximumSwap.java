// 670. Maximum Swap

public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(712367));
    }

    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int swapLeft = -1, swapRight = -1;

        int maxIdx = chars.length-1;
        for(int i=chars.length-1; i>=0; i--) {
            if(chars[i] < chars[maxIdx]) {
                swapLeft = i;
                swapRight = maxIdx;
            } else if(chars[i] > chars[maxIdx]){
                maxIdx = i;
            }
        }

        if(swapLeft != -1) {
            char tmp = chars[swapLeft];
            chars[swapLeft] = chars[swapRight];
            chars[swapRight]= tmp;
        }

        return Integer.valueOf(String.valueOf(chars));
    }

}