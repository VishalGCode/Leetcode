class Solution {
    public int longestSubsequence(int[] nums) {
    int xor=0;
    boolean nonzero=false;
    for(int num:nums){
        xor^=num;
        if(num>0) nonzero=true;
    }
    if(xor!=0) return nums.length;
    return nonzero?nums.length-1:0;
    }
}