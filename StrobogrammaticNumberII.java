// 247. Strobogrammatic Number II

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {

    public void run() {
        System.out.println(findStrobogrammatic(3));
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<>();
        recursion(list, "", n);

        return list;
    }

    private void recursion(List<String> list, String str, int n) {
        if(n == 0) {
            list.add(str);
            return;
        }

        if(n % 2 == 1) {
            recursion(list, "0", n-1);
            recursion(list, "1", n-1);
            recursion(list, "8", n-1);
        } else {
            if(n>2) recursion(list, "0"+str+"0", n-2);
            recursion(list, "1"+str+"1", n-2);
            recursion(list, "8"+str+"8", n-2);
            recursion(list, "6"+str+"9", n-2);
            recursion(list, "9"+str+"6", n-2);
        }
    }

}