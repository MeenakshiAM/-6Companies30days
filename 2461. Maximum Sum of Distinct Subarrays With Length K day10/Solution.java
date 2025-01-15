class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, maxSum = 0;
        int left = 0;
        boolean[] seen = new boolean[100001];

        for (int right = 0; right < nums.length; right++) {
            if (!seen[nums[right]]) {
                sum += nums[right];
                seen[nums[right]] = true;
                if (right - left + 1 == k) {
                    maxSum = Math.max(maxSum, sum);
                    seen[nums[left]] = false;
                    sum -= nums[left];
                    ++left;
                }
            } else {
                while (nums[left] != nums[right]) {
                    sum -= nums[left];
                    seen[nums[left]] = false;
                    ++left;
                }
                ++left;
            }
        }

        return maxSum;
    }
}