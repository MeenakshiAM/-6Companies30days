class Circular_game{
    public int findTheWinner(int n, int k) {
        int ans = solve(n,k)+1;
        return ans;
    }
    int solve(int n, int k){
        if(n==0){
            return 0;
        }
        return (solve(n-1,k)+k)%n;
    }
}