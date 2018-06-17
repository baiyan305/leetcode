// 853. Car Fleet

public class CarFleet {

    public static void main(String[] args) {

        for(int i=0; i<10; i++) {
            if(i==5) {
                i = 7;
            }

            System.out.println(i);
        }

        //System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        //System.out.println(carFleet(10, new int[]{6,8}, new int[]{3,2}));
        //System.out.println(carFleet(10, new int[]{8,3,7,4,6,5}, new int[]{4,4,4,4,4,4}));
        //System.out.println(carFleet(10, new int[]{0,4,2}, new int[]{2,1,3}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int[] road = new int[target+1];
        for(int i=0; i<position.length; i++) road[position[i]] = road[position[i]] == 0 ? speed[i] : Math.min(road[i], speed[i]);

        for(int right = road.length-1; right >=0; right--) {
            if(road[right] == 0) continue;

            double timeForRight = (double)(target - right) / road[right];
            for(int left = right-1; left>=0; left--) {
                if(road[left] == 0) continue;

                double timeForLeft = (double)(target - left) / road[left];
                if(timeForRight >= timeForLeft) {
                    road[left] = 0;
                } else {
                    right = left;
                    break;
                }
            }
        }

        int fleet = 0;
        for(int i=0; i<road.length; i++) {
            if(road[i] != 0) fleet++;
        }

        return fleet;

        /*
        int right = road.length-1;
        while(right>0) {
            if(road[right] == 0) {
                right--;
                continue;
            }

            double timeForRight = (double)(target - right) / road[right];
            int left = right-1;
            while(left >= 0) {
                if(road[left] == 0) {
                    left--;
                    continue;
                }
                double timeForLeft = (double)(target - left) / road[left];
                if(timeForRight >= timeForLeft) {
                    road[left] = 0;
                    left--;
                } else {
                    right = left;
                    break;
                }
            }
            if(left == -1) right = -1;
        }
        */
    }

}