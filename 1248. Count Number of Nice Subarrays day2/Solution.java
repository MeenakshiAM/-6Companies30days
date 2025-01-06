class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
int oddCount = 0;
int start = 0;

for (int end = 0; end < nums.length; end++) {
    if (nums[end] % 2 != 0) {
        oddCount++;
    }
    while (oddCount > k) {
        if (nums[start] % 2 != 0) {
            oddCount--;
        }
        start++;
    }
    if (oddCount == k) {
        int tempStart = start;
        while (tempStart < nums.length && nums[tempStart] % 2 == 0) {
            tempStart++;
        }
        count += tempStart - start + 1;
    }
}

    return count;

    }
}