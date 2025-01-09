public class Solution {
    private static final int INF = Integer.MAX_VALUE / 2; 

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        int[][] adjMatrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(adjMatrix[i], INF);
            adjMatrix[i][i] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            adjMatrix[u][v] = Math.min(adjMatrix[u][v], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (adjMatrix[i][k] < INF && adjMatrix[k][j] < INF) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);
            int costToConvert = adjMatrix[srcChar - 'a'][tgtChar - 'a'];
            if (costToConvert == INF) {
                return -1;
            }
            totalCost += costToConvert;
        }
        
        return totalCost;
    }
}
