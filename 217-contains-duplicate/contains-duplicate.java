class Solution {
    public boolean containsDuplicate(int[] nums) {
    if(nums.length<2) return false;
    HashSet<Integer> set = new HashSet<>(nums.length*2);
    for(int i=0;i<nums.length;i++){
        if(!set.add(nums[i])) return true;
    }
    return false;
    }
}