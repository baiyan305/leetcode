// 120. Triangle

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Triangle {
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(2);
		List<Integer> list2 = Arrays.asList(3,4);
		List<Integer> list3 = Arrays.asList(6,5,7);
		List<Integer> list4 = Arrays.asList(4,1,8,3);
		
		List<List<Integer>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		
		System.out.println(minimumTotal(list));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
		
		int[] dp = new int[triangle.size()];
		dp[0] = triangle.get(0).get(0);
		
		for(int i=1; i<triangle.size(); i++){
			for(int j=triangle.get(i).size()-1; j>=0; j--){
				if(j == i) dp[j] = dp[j-1] + triangle.get(i).get(j);
				else if(j == 0) dp[0] = dp[0] + triangle.get(i).get(j);
				else dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
			}
		}
		
		int min = dp[0];
		for(int i : dp)
			min = Math.min(min, i);
		
		return min;
    }
	
}