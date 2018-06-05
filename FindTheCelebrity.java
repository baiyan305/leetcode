// 277. Find the Celebrity

public class FindTheCelebrity {

    public static void main(String[] args) {
        
    }


    public int findCelebrity(int n) {
        if(n==0) return -1;

        int celebrity = 0;
        for(int i=1; i<n; i++) {
            if(knows(celebrity, i)) celebrity = i;
        }

        for(int i=0; i<n; i++) {
            if(i != celebrity && (knows(celebrity, i) ||!knows(i, celebrity))) return -1;
        }

        return celebrity;
    }

    private boolean knows(int a, int b) {

    }
}