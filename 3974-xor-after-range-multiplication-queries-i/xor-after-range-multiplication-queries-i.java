class Solution {
    final int mod=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] t: queries){
            int l=t[0], r=t[1], k=t[2], v=t[3], idx=l;
            while(idx<=r){
                long temp=nums[idx];
                nums[idx]=(int)((temp*v)%mod);
                idx+=k;
            }
        }
        int ans=0;
        for(int num:nums) ans ^=num;
        return ans;
    }
} 