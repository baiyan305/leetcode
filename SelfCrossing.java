// 335. Self Crossing

public class SelfCrossing {

    public void run() {
        System.out.println(isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(isSelfCrossing(new int[]{1, 1, 1, 1}));
    }

    // 数学几何方法, 太难了, 自己想不出来.
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        for(int i=3; i<len; i++) {
            //考虑当前x[i]是第四条边的情况, 第四条边和第一条边相交.
            if(x[i]>=x[i-2] && x[i-1]<=x[i-3]) return true;
            //考虑当前x[i]是第五条边的情况, 第五条边和第一条边相交.
            if(i>=4 && x[i-1] == x[i-3] && x[i]+x[i-4] >= x[i-2]) return true;
            //考虑当前x[i]是第六条边的情况, 第六条边和第一条边相交.
            if(i>=5 && x[i-1] < x[i-3] && x[i-5] + x[i-1] >= x[i-3] && x[i-2] > x[i-4] && x[i] + x[i-4] >= x[i-2]) return true;
        }

        return false;
    }

    /* 两个HashMap存储已经遍历过的的横边和竖边. 之后看新加入的边x[i]是否和HashMap中的横竖边相交. 可以accept, 但是效率在Leetcode上是1%.
    public boolean isSelfCrossing(int[] x) {
        HashMap<Integer, List<int[]>> horizontal = new HashMap<>(), vertical = new HashMap<>();

        int oldY = 0, oldX = 0, posY = 0, posX = 0, i =0;
        for(int distance : x) {
            int d = distance;

            while(d-- > 0) {
                if(i%2 == 0) posX += (i==0 ? 1 : -1);
                else posY += (i==1 ? 1 : -1);

                // check if self crossing;
                if(vertical.containsKey(posX)) {
                    List<int[]> vLines = vertical.get(posX);
                    for(int[] line : vLines) {
                        if(posY >= line[0] && posY <= line[1]) return true;
                    }
                }
                if(horizontal.containsKey(posY)) {
                    List<int[]> hLines = horizontal.get(posY);
                    for(int[] line : hLines) {
                        if(posX >= line[0] && posX <= line[1]) return true;
                    }
                }
            }

            if(i%2 == 0) {
                if(!horizontal.containsKey(posY)) horizontal.put(posY, new ArrayList<>());
                horizontal.get(posY).add(new int[]{Math.min(oldX, posX), Math.max(oldX, posX)});
            } else {
                if(!vertical.containsKey(posX)) vertical.put(posX, new ArrayList<>());
                vertical.get(posX).add(new int[]{Math.min(oldY, posY), Math.max(oldY, posY)});
            }

            oldY = posY;
            oldX = posX;
            if(++i == 4) i = 0;
        }

        return false;
    }
    */

}
