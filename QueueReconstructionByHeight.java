// 406. Queue Reconstruction by Height

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public void run() {
        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        int[][] queue = reconstructQueue(people);

        System.out.println("123");
    }

    /*
    * 例子: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    *
    * 将这个数组排序，排序规则:
    *     如果数组第一位不一样, 按照第一位从大到小排序.
    *     如果数组第一位一样, 按照第二位从小到大排序.
    *
    * 那么上面的例子排序后:
    * [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
    *
    * 然后将排序后的数组, 依次插入到一个List中. 按照数组的第二位作为坐标插入List.
    *
    * 比如, 当处理[6, 1]的时候, List中是如下情况: [7,0], [7,1]
    * List中的所有数组都大于等于[6, 1], 所以[6, 1]放入数组的第2个位置就对了.
    *
    * 每次处理一个新的数组时, List中所有的数组都大于等于这个待处理的数组.
    * 所以待处理数组的k值，就是它在List中的位置. 并且它并不影响List中它后面的元素.
    * 因为它必然小于List中后面的元素.
    *
    * */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] a, int[]b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> list = new ArrayList<>();
        for(int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[list.size()][2]);
    }

}
