// 870. Advantage Shuffle

import java.util.TreeMap;

public class AdvantageShuffle {

    public void run() {
        int[] ret1 = advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11});
        for(int i : ret1) System.out.print(i+" ");
        System.out.println();
        int[] ret2 = advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});
        for(int i : ret2) System.out.print(i+" ");
        System.out.println();
    }

    // 贪心算法。
    // 对于B数组中的每一个数组，需要从A数组中选出一个数组来，放到相同的位置。
    // 选择的原则是：从A数组中选出比 B[i] 大的最小数字。如果没有比 B[i]的数组，那么选最小的。
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int a : A) tree.put(a, tree.getOrDefault(a, 0)+1);

        int[] ret = new int[B.length];
        for(int i=0; i<ret.length; i++) {
            Integer key = tree.higherKey(B[i]);
            if(key == null) key = tree.firstKey();

            int count = tree.get(key);
            if(count == 1) tree.remove(key);
            else tree.put(key, count-1);

            ret[i] = key;
        }

        return ret;
    }

}