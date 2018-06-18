// 683. K Empty Slots

public class KEmptySlots {

    public static void main(String[] args) {
        System.out.println(kEmptySlots(new int[]{1,3,2}, 1));
        System.out.println(kEmptySlots(new int[]{1,2,3}, 1));
        System.out.println(kEmptySlots(new int[]{1,3,2}, 0));
        System.out.println(kEmptySlots(new int[]{6,5,8,9,7,1,10,2,3,4}, 2));
        System.out.println(kEmptySlots(new int[]{3,9,2,8,1,6,10,5,4,7}, 1));

    }

    // O(n). 另外还有一种使用TreeSet的解法.
    public static int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length < k+2) return -1;

        int[] days = new int[flowers.length];
        for(int i=0; i<flowers.length; i++) days[flowers[i] - 1] = i+1;

        int answer = -1;
        for(int left = 0, right = left+k+1; right< days.length;) {
            int idx = left+1;
            while(idx<right) {
                if(days[idx] > days[left] && days[idx] > days[right]) idx++;
                else break;
            }

            if(idx == right) {
                int tmp = Math.max(days[left], days[right]);
                answer = answer == -1 ? tmp : Math.min(answer, tmp);
            }

            left = idx;
            right = left+k+1;
        }

        return answer;
    }

}
