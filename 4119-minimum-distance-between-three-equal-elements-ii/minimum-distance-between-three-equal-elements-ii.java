class Solution{
    public int minimumDistance(int[] nums){
        Map<Integer, int[]> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            int val = nums[i];
            map.putIfAbsent(val, new int[]{-1, -1});
            int[] arr = map.get(val);
            int secondLast = arr[0],last = arr[1];
            if (secondLast != -1) ans = Math.min(ans, i-secondLast);
            arr[0] = last;arr[1] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : 2 * ans;
    }
}