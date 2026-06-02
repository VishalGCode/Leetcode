class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long  prod1=1;
        for(int i=0; i<nums.length; i++){
            prod1 = prod1 * nums[i];
        }        
        if(prod1 != target*target) return false;
        return dfs(nums, 0, 1L, 0, target);
    }
    private boolean dfs(int[] nums, int ind, long prod, int count, long target){
        if(prod == target) return count > 0 && count < nums.length;
        if(ind == nums.length || prod > target || prod % prod !=0) return false;
        if(prod <= target / nums[ind]){
            if(dfs(nums, ind+1, prod*nums[ind], count+1, target)){
                return true;
            }
        }
        return dfs(nums, ind+1, prod, count, target);
    }
}