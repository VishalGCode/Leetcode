class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] f = new int[101];
        int count=0;
        for(int num:nums){
            count += f[num];
            f[num]++;
        }
        return count;
    }
}