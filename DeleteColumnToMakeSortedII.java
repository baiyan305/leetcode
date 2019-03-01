// 955. Delete Columns to Make Sorted II

public class DeleteColumnToMakeSortedII {

    public int minDeletionSize(String[] A) {
        if(A == null || A.length == 0) return 0;
        int len = A[0].length();

        // 表示当前的字符串和前面的比较后，是否是排好序的
        // 当所有的字符串都排好序后，就可以返回了
        //
        // 比如:
        // aabc
        // bzzz
        // 那么ordered[1]就是排好序的，因为A[1]必然比A[0]大, 因为第一个字母的原因
        //
        // 关键是要处理字母相同的情况情况:
        //
        // 比如:
        // adc
        // bbd
        // 当遍历到第二位的时候，d比b大，违反了规则，那么这行需要删吗？不需要，因为高一位的已经拍好序了
        //
        // 再比如:
        // adc
        // abd
        // 当遍历到第二位的时候，d比b大，违反了规则，那么这行需要删吗？需要，因为高一位的好没排好序
        //
        // 所以用一个boolean[] 记录每个字符串是否已经排序了
        boolean[] ordered = new boolean[A.length];

        int res = 0;
        for(int i=0; i<len; i++) { // 字符坐标
            boolean delete = false;
            for(int j=1; j<A.length; j++) { // 字符串坐标
                // 如果前一个字符串的字母j比后面的字符串的j大，并且j前面是相等的情况下
                // 就是无论如何要删除的
                if(A[j-1].charAt(i) > A[j].charAt(i) && !ordered[j]) {
                    delete = true;
                    res++;
                    break;
                }
            }

            // 如果这一列不需要删除，就需要更新ordered的情况
            // 当后面字符串的字母比前面字符串的字母大，就更新ordered的值
            if(!delete) {
                for(int j=1; j<A.length; j++)
                    if(A[j-1].charAt(i) < A[j].charAt(i))
                        ordered[j] = true;
            }
        }

        return res;
    }

}
