// 391. Perfect Rectangle

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

    public void run() {
        int[][] rectangles1 = {
                {1,1,3,3},
                {3,1,4,2},
                {3,2,4,4},
                {1,3,2,4},
                {2,3,3,4}
        };
        System.out.println(isRectangleCover(rectangles1));

        int[][] rectangles2 = {
                {1,1,2,3},
                {1,3,2,4},
                {3,1,4,2},
                {3,2,4,4}
        };
        System.out.println(isRectangleCover(rectangles2));

        int[][] rectangles3 = {
                {1,1,3,3},
                {3,1,4,2},
                {1,3,2,4},
                {3,2,4,4}
        };
        System.out.println(isRectangleCover(rectangles3));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int area = 0;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for(int[] rectangle : rectangles) {
            minX = Math.min(minX, rectangle[0]);
            maxX = Math.max(maxX, rectangle[2]);
            minY = Math.min(minY, rectangle[1]);
            maxY = Math.max(maxY, rectangle[3]);
            String leftTop = rectangle[0] + ":" + rectangle[3];
            String leftBot = rectangle[0] + ":" + rectangle[1];
            String rightTop = rectangle[2] + ":" + rectangle[3];
            String rightBot = rectangle[2] + ":" + rectangle[1];
            if(set.contains(leftTop)) set.remove(leftTop);
            else set.add(leftTop);
            if(set.contains(leftBot)) set.remove(leftBot);
            else set.add(leftBot);
            if(set.contains(rightTop)) set.remove(rightTop);
            else set.add(rightTop);
            if(set.contains(rightBot)) set.remove(rightBot);
            else set.add(rightBot);

            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }

        if(!set.contains(minX + ":" + minY) ||
                !set.contains(minX + ":" + maxY) ||
                !set.contains(maxX + ":" + minY) ||
                !set.contains(maxX + ":" + maxY)) return false;

        return (maxX-minX) * (maxY-minY) ==  area;
    }

}
