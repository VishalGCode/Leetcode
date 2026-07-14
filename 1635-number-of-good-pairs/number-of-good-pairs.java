class Solution {
    public int numIdenticalPairs(int[] nums) {
    int track=0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int num : nums){
        if(map.containsKey(num)){
            track += map.get(num);
        }
        map.put(num, map.getOrDefault(num, 0) + 1);
    } 
    return track;
    }
}