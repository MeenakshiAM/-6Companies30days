import java.util.*;
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
       Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int minCost = directCost(price, needs);
        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    valid = false; 
                    break;
                }
                newNeeds.add(needs.get(i) - offer.get(i));
            }
            if (valid) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, newNeeds, memo));
            }
        }
        memo.put(needs, minCost);
        return minCost;
    }

    private int directCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        return cost;
    }
}