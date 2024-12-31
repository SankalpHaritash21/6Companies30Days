class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nX= Math.max(x1,Math.min(x2, xCenter));
        int nY= Math.max(y1,Math.min(y2, yCenter));

        int dX= xCenter - nX;
        int dY= yCenter - nY;

        return dX*dX + dY*dY <= radius*radius;
    }
}