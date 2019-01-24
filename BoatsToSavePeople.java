// 881. Boats to Save People

public class BoatsToSavePeople {

    // 这道题是贪心算法+双指针，但是常规思路是很不好解释的
    // 
    // 先排序，之后双指针
    // 如果最轻的和最重的一起没有超过limit，就坐一条船，light++, heavy--
    // 否则最重的自己坐一条船，light不动, heavy--
    //
    // 如果理解双指针的思路呢，核心是从最轻的人为中心来考虑
    // 因为一条船最多可以坐2个人，那么从最轻的开始，为最轻的人找一个搭档，找谁呢？
    // 肯定找最重的，如果他们一起合起来没有超过limit，就坐一条船，没毛病
    // 如果超过了呢，最重的人和最轻的人一起都超过了，那么最重的人，无论和谁一起都会超limit
    // 所以最重的人，一定是自己坐一条船
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int light = 0, heavy = people.length-1, boats = 0;
        while(light < heavy) {
            if(people[light] + people[heavy] > limit) {
                heavy--;
            } else {
                light++;
                heavy--;
            }
            boats++;
        }

        if(light == heavy) boats++;

        return boats;
    }

}
