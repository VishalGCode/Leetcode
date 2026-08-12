class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
    Map<Integer, Integer> freq=new HashMap<>();
    int left=0;
    int maxlen=0;
    for(int i=0;i<nums.length;i++){
        freq.merge(nums[i],1,Integer::sum);
        while(freq.get(nums[i])>k){
            freq.merge(nums[left],-1,Integer::sum);
            left++;
        }
        maxlen=Math.max(maxlen,i-left+1);
    }   
    return maxlen;
    }
}