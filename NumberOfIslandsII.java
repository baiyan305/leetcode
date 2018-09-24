// Add 305. Number of Islands II
// https://www.jianshu.com/p/34d6199f4683

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

    public void run() {
        int[][] positions = {
                {0,0},
                {0,1},
                {1,2},
                {2,1}
        };
        System.out.println(numIslands2(3,3, positions));
        System.out.println("123");
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] roots = new int[m * n], weight = new int[m * n], islands = {0};
        Arrays.fill(roots, -1);

        List<Integer> list = new ArrayList<>();
        for(int[] pos : positions) {
            int y = pos[0], x = pos[1], id = y * n + x;

            roots[id] = id;
            weight[id] = 1;
            islands[0]++;
            //union with left
            if(x-1>=0) {
                int id_left = y * n + x - 1;
                if(roots[id_left] != -1) union(roots, weight, id_left, id, islands);
            }
            //union with up
            if(y-1>=0) {
                int id_up = (y-1) * n + x;
                if(roots[id_up] != -1) union(roots, weight, id_up, id, islands);
            }
            //union with right
            if(x+1<n) {
                int id_right = y * n + x + 1;
                if(roots[id_right] != -1) union(roots, weight, id_right, id, islands);
            }
            //union with down
            if(y+1<m) {
                int id_down = (y+1) * n + x;
                if(roots[id_down] != -1) union(roots, weight, id_down, id, islands);
            }

            list.add(islands[0]);
        }

        return list;
    }

    // Weighted union
    private void union(int[] roots, int[] weight, int id1, int id2, int[] island) {
        int root1 = findRoot(roots, id1);
        int root2 = findRoot(roots, id2);
        if(root1 != root2) {
            if(weight[root1] >= weight[root2]) {
                roots[root2] = root1;
                weight[root1] += weight[root2];
            } else {
                roots[root1] = root2;
                weight[root2] += weight[root1];
            }

            island[0]--;
        }
    }

    // Find root with path compression
    private int findRoot(int[] roots, int id) {
        while(id != roots[id]) {
            int root = roots[id];
            if(roots[root] != root) roots[id] = roots[root];
            id = root;
        }
        return id;
    }

}
