class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // A mountain requires at least 3 elements

        int longest = 0;
        int i = 1; // Start from the second element

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                longest = Math.max(longest, right - left + 1);
                i = right;
            } 
            else {
                i++;
            }
        }

        return longest;
    }
}
