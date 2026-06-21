class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length, sum=0, total=0;
        Arrays.sort(costs);
        for(int i=0; i<n; i++){
            if((sum+costs[i]) <= coins){
                sum+=costs[i];
                total++;
            }
        }    
        return total;
    }
}