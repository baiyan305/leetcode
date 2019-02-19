// 373. Find K Pairs with Smallest Sums

public class FindKPairsWithSmallestSums {

    // klogk 做法, 相当于merge K sorted array
    // 比如对于 nums1: [1,5,7]
    //        nums2:  [2,4,8]
    // 将他们转化为3个sorted array
    // arr1   1,2   1,4   1,8
    // arr2   5,2   5,4   5,8
    // arr3   7,2   7,4   7,8
    //
    // 得到3个sorted的array, array是 array of int[]
    // 然后就是将每个array的第一个推入PQ中, 然后取出最小的，比如是arr1[0], 之后将arr1[1]加入pq中
    // 就是merge K sorted array的思路
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len2 = nums2.length;

        PriorityQueue<int[]> queue =
                new PriorityQueue<>((a,b)->nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);

        for(int i=0; i<Math.min(k, nums1.length); i++) {
            if(0 < len2)
                queue.offer(new int[]{i, 0});
        }

        List<int[]> list = new ArrayList<>();
        while(!queue.isEmpty() && list.size() < k) {
            int[] min = queue.poll();
            list.add(new int[]{nums1[min[0]], nums2[min[1]]});
            if(min[1]+1 < len2)
                queue.offer(new int[]{min[0], min[1]+1});
        }

        return list;
    }

}
