class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        return solve(n, days, costs);    
    }
    private int solve(int n, int[] days, int[] costs){
        int[] dp = new int[n+1];
        dp[n]=0;
        for(int k=n-1; k>=0; k--){
            int option1=costs[0]+dp[k+1];
            int i=k;
            while(i<n && days[i]<days[k]+7) i++;
            int option2=costs[1]+dp[i];
            i=k;
            while(i<n && days[i]<days[k]+30) i++;
            int option3=costs[2]+dp[i];
            int store=Math.min(option1, option2);
            dp[k]=Math.min(store, option3);
        }
        return dp[0];
    }
}