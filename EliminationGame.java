// 390. Elimination Game

public class EliminationGame {

    public void run() {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(1));
        System.out.println(lastRemaining(2));
        System.out.println(lastRemaining(3));
        System.out.println(lastRemaining(12));
        System.out.println(lastRemaining(10));
    }

    public int lastRemaining(int n) {
        int remaining = n, left = 1, right = n, direction = 1, offset = 1;
        while(remaining > 2) {
            if(remaining % 2 == 1) {
                left += offset;
                right -= offset;
            } else {
                if(direction == 1) left += offset;
                else right -= offset;
            }

            offset *= 2;
            direction *= -1;
            remaining /= 2;
        }

        return direction == 1 ? right : left;
    }

}
