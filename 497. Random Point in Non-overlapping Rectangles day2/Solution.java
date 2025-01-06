public class Solution {
    private int[][] rects;
    private List<Integer> cumulativeAreas;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.cumulativeAreas = new ArrayList<>();
        this.rand = new Random();

        int totalArea = 0;
        for (int[] rect : rects) {
            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;
            totalArea += width * height;
            cumulativeAreas.add(totalArea);
        }
    }

    public int[] pick() {
        int target = rand.nextInt(cumulativeAreas.get(cumulativeAreas.size() - 1)) + 1;
        int rectIndex = binarySearch(target);
        int[] rect = rects[rectIndex];
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
        int x = x1 + rand.nextInt(x2 - x1 + 1);
        int y = y1 + rand.nextInt(y2 - y1 + 1);

        return new int[]{x, y};
    }

    int binarySearch(int target) {
        int left = 0, right = cumulativeAreas.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cumulativeAreas.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
