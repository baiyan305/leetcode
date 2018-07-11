// 223. Rectangle Area

public class RectangleArea {

    public void run() {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftBottomX = Math.max(A, E), leftBottomY = Math.max(B,F);
        int rightTopX = Math.min(C,G), rightTopY = Math.min(D, H);

        int overlap = 0;
        if((rightTopX > leftBottomX) && (rightTopY > leftBottomY)) overlap = (rightTopY - leftBottomY) * (rightTopX - leftBottomX);

        return (C-A) * (D-B) + (G-E) * (H-F) - overlap;
    }

}
