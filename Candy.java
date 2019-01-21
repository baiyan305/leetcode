// 135. Candy

public class Candy {
	
	// 数组就像高低起伏的山脊线。
	// 低点的糖果是1。
	// 对于上升曲线，糖果数量一定是从1一直增加。比如3,6,8,9, 那么对应的糖果是1，2，3，4
	// 加入从9开始下降了，比如3,6,8,9,8,7,6,5，那么要递减，到最后的5时，就时-1了，所以9分配的糖果，是左边上升曲线和右边下降曲线中，比较长的值
	// 
	// 先从左向右扫描，算出每个递增曲线的长度，顶点的糖果数，暂时设置为左边上升曲线的长度
	// 然后从右向左扫描，算出每个递减曲线的长度，与顶点的糖果数，取比较大的值。
	public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        
        for(int i=1; i<len; i++)
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
        
        for(int i=len-2; i>=0; i--)
            if(ratings[i] > ratings[i+1])
                candy[i] = Math.max(candy[i], candy[i+1]+1);
        
        int res = 0;
        for(int i : candy)
            res += i;
        
        return res;
    }
	
	
	// 上面的方法，扫描2次，还用了额外空间
	// 有扫一遍，不需要额外空间的做法
	
}