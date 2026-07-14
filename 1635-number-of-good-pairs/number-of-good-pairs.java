class Solution {
    public int numIdenticalPairs(int[] nums) {
    Arrays.sort(nums);
    int count=0;
    int i=0;
    while(i<nums.length){
        int j = i;
        while(j<nums.length && nums[j]==nums[i]) j++;
        int n=j-i;
        if(n>1) count += (n*(n-1))/2;
        i=j;
    }
    return count;
    }
}