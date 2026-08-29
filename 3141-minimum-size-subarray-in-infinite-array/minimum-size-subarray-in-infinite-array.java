class Solution {
    public int minSizeSubarray(int[] nums, int target) {
    long totalsum=0;
    for(int num:nums) totalsum+=num;
    int n=nums.length;
    long fullcopy=target/totalsum;
    int remtarget=(int) (target%totalsum);
    if(remtarget==0) return (int) (fullcopy*n);
    int minlen=Integer.MAX_VALUE;
    long currentsum=0;
    int left=0;
    for(int right=0;right<2*n;right++){
        currentsum+=nums[right%n];
        while(currentsum > remtarget){
            currentsum-=nums[left%n];
            left++;
        }
        if(currentsum==remtarget){
            minlen=Math.min(minlen,right-left+1);
        }
    }    
    return minlen==Integer.MAX_VALUE?-1:(int) (fullcopy*n+minlen);
    }
}