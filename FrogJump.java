// 403. Frog Jump

import java.util.HashMap;
import java.lang.Integer;

public class FrogJump {
	
	public static void main(String[] args) {
		int[] stones = {0,1,2,3,4,8,9,11};
		System.out.println(canCross(stones));
	}
	
	public static boolean canCross(int[] stones) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<stones.length; i++) map.put(stones[i], i);
		
		return recursion(map, stones[stones.length-1], 0, 0);
    }
	
	private static boolean recursion(HashMap<Integer, Integer> map, int endPos, int curPos, int prevStep) {
		if(curPos == endPos) return true;
		if(!map.containsKey(curPos) || curPos > endPos) return false;
		
		return (prevStep-1<=0 ? false : recursion(map, endPos, curPos+prevStep-1, prevStep-1)) || (prevStep == 0 ? false : recursion(map, endPos, curPos+prevStep, prevStep)) || recursion(map, endPos, curPos+prevStep+1, prevStep+1);
	}
	
}