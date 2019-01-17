// 845. Longest Mountain in Array

public class LongestMountainInArray {
	
	public int longestMountain(int[] A) {
        
        //increase是增长数组的长度
        //decrease是减小数组的长度
        int increase = 1, decrease = 1, res = 0;
        
        for(int i=1; i<A.length; i++) {
            //如果是平的，那么不是升也不是降，需要从头开始计算
            //将increase和decrease都设置为1
            if(A[i] == A[i-1]) {
                increase = 1;
                decrease = 1;
            } else if(A[i] > A[i-1]) {
                //如果是上升的，有两种情况
                //第一种是刚刚由下降转为上升，就将increase设置为2
                if(i-2 >= 0 && A[i-2] > A[i-1])
                    increase = 2;
                //第二种是已经上升了至少一次了，increase++
                else
                    increase++;
            } else {
                //如果是下降的，有两种情况
                //第一种是刚刚由上升转为下降，就将decrease设置为2
                if(i-2 >= 0 && A[i-2] < A[i-1])
                    decrease = 2;
                //第二种是已经下降了至少一次了，decrease++
                else
                    decrease++;
                
                //只在下降时，才计算mountain长度
                if(increase > 1)
                    res = Math.max(res, increase + decrease -1);
            }
        }
        
        return res;
    }
	
}