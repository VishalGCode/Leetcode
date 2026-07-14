class Solution {
    public List<Integer> findMissingElements(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    // ans = Arrays.asList(nums);
    // int[] sum = new int[nums.length];
    HashSet<Integer> set = new HashSet<>();
    int min=nums[0], max = nums[0];
    for(int num : nums){
        max = Math.max(num, max);
        min = Math.min(num, min);
        set.add(num);
    }
    for(int i=min; i<max; i++){
        if(set.contains(i)) continue;
        else ans.add(i);
    }
    Collections.sort(ans);
    return ans;
    }
}