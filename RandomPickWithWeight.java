// 528. Random Pick with Weight

// 这道题给几个数字的权重
// 比如:
// weight: 4  2  2  3  1  4
// index:  0  1  2  3  4  5
// preSum: 3  5  7  10 11 15
//
// preSum的含义是前面有多少个数字
// preSum中，第一个数字3的意思是, 如果随机数字是0-3, 就是0
// 第二个数字5的意思是，如果随机数字是4-5, 就是1
// ...
//
// 然后随机数字random产生后，对preSum做binary search，找到第一个大于等于random的数字
public class RandomPickWithWeight {
    int[] range;
    int total;
    Random random;

    public RandomPickWithWeight(int[] w) {
        range = new int[w.length];
        for(int i=0; i<w.length; i++) {
            total += w[i];
            range[i] = total-1;
        }

        random = new Random();
    }

    public int pickIndex() {
        int idx = random.nextInt(total);
        int left = 0, right = range.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(range[mid] == idx) return mid;
            else if(range[mid] < idx)
                left = mid+1;
            else
                right = mid-1;
        }

        return left;
    }
}
