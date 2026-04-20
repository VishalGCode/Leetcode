class Solution {
    public int maxDistance(int[] colors) {
    int maxi=Integer.MIN_VALUE;
    int n=colors.length;
    for(int i=0;i<n;i++){
        for(int j=1;j<n;j++){
            if(colors[i] != colors[j]){
                maxi=Math.max(maxi, Math.abs(i-j));
            }
        } 
    }
    return maxi;
    }
}