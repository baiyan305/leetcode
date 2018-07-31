// 356. Line Reflection

public class LineReflection {
	
	public void run() {
        int[][] points1 = {
                {1,1},
                {-1,1}
        };
        System.out.println(isReflected(points1));

        int[][] points2 = {
                {1,1},
                {-1,-1}
        };
        System.out.println(isReflected(points2));

        int[][] points3 = {
                {0,0},
                {1,0}
        };
        System.out.println(isReflected(points3));

        int[][] points4 = {
                {1,2},
                {2,2},
                {1,4},
                {2,4}
        };
        System.out.println(isReflected(points4));

        int[][] points5 = {
                {1,1},
                {-3,1}
        };
        System.out.println(isReflected(points5));
    }

    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();

        int xSum = 0, xMax = Integer.MIN_VALUE, xMin = Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++) {
            set.add(points[i][0] + ":" + points[i][1]);
            xMax = Math.max(xMax, points[i][0]);
            xMin = Math.min(xMin, points[i][0]);
        }

        double xMid = (double)(xMax + xMin) / 2;
        for(int i=0; i<points.length; i++) {
            int reflectX = (int)(xMid * 2) - points[i][0];
            if(!set.contains(reflectX + ":" + points[i][1])) return false;
        }

        return true;
    }
	
}