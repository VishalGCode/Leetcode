class Solution {
    public List<Integer> findMissingElements(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    // ans = Arrays.asList(nums);
    // int[] sum = new int[nums.length];
    // HashSet<Integer> set = new HashSet<>();
    boolean[] present = new boolean[101];
    int min=101, max = 0;
    for(int num : nums){
        max = Math.max(num, max);
        min = Math.min(num, min);
        present[num]=true;
    }
    for(int i=min; i<max; i++){
        if(!present[i]) ans.add(i);
    }
    Collections.sort(ans);
    return ans;
    }
}