class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        // Count bulls and track the frequency of unmatched digits
        int[] secretCount = new int[10];  // To store frequency of digits in secret
        int[] guessCount = new int[10];   // To store frequency of digits in guess

        // Step 1: Calculate bulls and collect unmatched digits
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;  // Exact match
            } else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}