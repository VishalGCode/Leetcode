class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        int[] even = new int[k];
        int[] odd = new int[k];
        for(int i=0; i<n; i++){
            int r=nums[i]%k;
            if(i%2==0){
                even[r]++;
            }else{
                odd[r]++;
            }
        }
        int ops=Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(i==j) continue;
                int currOps=0;
                for(int r=0; r<k; r++){
                    if(even[r]>0){
                        int diff_up=(i-r+k)%k;
                        int diff_down=(r-i+k)%k;
                        currOps+=even[r]*Math.min(diff_up,diff_down);
                    }
                }
                for(int r=0; r<k; r++){
                    if(odd[r]>0){
                        int diff_up=(j-r+k)%k;
                        int diff_down=(r-j+k)%k;
                        currOps+=odd[r]*Math.min(diff_up,diff_down);
                    }
                }
                ops=Math.min(ops,currOps);
            }
        }
        return ops;    
    }
}