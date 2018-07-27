// 149. Max Points on a Line

public class MaxPointsOnALine {
	
	public int maxPoints(Point[] points) {
        HashMap<String, Integer> map = new HashMap<>();

        int ret = 0;
        for(int i=0; i<points.length; i++) {
            map.clear();
            int duplicate = 0, max = 0;
            for(int j=i+1; j<points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x==0 && y==0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x+":"+y;
                if(!map.containsKey(key)) map.put(key, 0);
                map.put(key, map.get(key)+1);
                max = Math.max(max, map.get(key));
            }

            ret = Math.max(ret, max+duplicate+1);
        }

        return ret;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
	
}