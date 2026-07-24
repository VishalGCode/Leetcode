class Solution {
    public int uniqueXorTriplets(int[] nums) {
    int count=0, n=nums.length;
    if(n<=2) return n;
    for(int i: nums) count|=i;
    return count+1;
    }
}