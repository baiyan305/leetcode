// 403. Frog Jump
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.lang.Integer;
import java.util.Map;

public class FrogJump {
	
	public static void main(String[] args) {
		int[] stones = {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}

	public static boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0 || stones[0] != 0 || stones[1] != 1) return false;
	
		Map<Integer, HashSet<Integer>> map = new HashMap<>();
		for(int stone : stones) map.put(stone, new HashSet<>());
		map.get(0).add(0);
		
		for(int i=0; i<stones.length; i++) {
			int stone = stones[i];
			
			for(int lastStep : map.get(stone)) {
				for(int k=-1; k<=1; k++) {
					int newStone = stone + lastStep + k;
					if(newStone != stone && map.containsKey(newStone)) {
						map.get(newStone).add(lastStep + k);
					}
				}
			}
		}
		
		return map.get(stones[stones.length-1]).size() > 0;
    }
	
}