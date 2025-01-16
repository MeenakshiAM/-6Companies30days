class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        String order = "!#$%&*?@^";
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        Character[] nutsArray = new Character[n];
        Character[] boltsArray = new Character[n];

        for (int i = 0; i < n; i++) {
            nutsArray[i] = nuts[i];
            boltsArray[i] = bolts[i];
        }

        Arrays.sort(nutsArray, (a, b) -> Integer.compare(orderMap.get(a), orderMap.get(b)));
        Arrays.sort(boltsArray, (a, b) -> Integer.compare(orderMap.get(a), orderMap.get(b)));
        for (int i = 0; i < n; i++) {
            nuts[i] = nutsArray[i];
            bolts[i] = boltsArray[i];
        }
    }
}