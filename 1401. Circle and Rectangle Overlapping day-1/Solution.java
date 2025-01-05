class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xClosest = clamp(xCenter, x1, x2);
        int yClosest = clamp(yCenter, y1, y2);
        int dx = xClosest - xCenter;
        int dy = yClosest - yCenter;

        return dx * dx + dy * dy <= radius * radius;
    }
    
    int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));  
    }
}