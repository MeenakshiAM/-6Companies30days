class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;
        int[] palindromeLengths = new int[1 << n];
        for (int mask = 1; mask < (1 << n); mask++) {
            if (isPalindrome(s, mask)) {
                palindromeLengths[mask] = Integer.bitCount(mask);
            }
        }

        for (int mask1 = 1; mask1 < (1 << n); mask1++) {
            if (palindromeLengths[mask1] == 0)
                continue;
            for (int mask2 = mask1 + 1; mask2 < (1 << n); mask2++) {
                if ((mask1 & mask2) == 0) {
                    maxProduct = Math.max(maxProduct, palindromeLengths[mask1] * palindromeLengths[mask2]);
                }
            }
        }

        return maxProduct;
    }

    private boolean isPalindrome(String s, int mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((mask & (1 << i)) != 0) {
                sb.append(s.charAt(i));
            }
        }
        String subseq = sb.toString();
        int left = 0, right = subseq.length() - 1;
        while (left < right) {
            if (subseq.charAt(left) != subseq.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}