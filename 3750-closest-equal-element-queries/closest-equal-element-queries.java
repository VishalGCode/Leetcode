class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
    Map<Integer, List<Integer>> map= new HashMap<>();
    for(int i=0;i<nums.length;i++){
        map.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);
    }
    List<Integer> ans = new ArrayList<>();
    for(int q: queries){
        List<Integer> v=map.get(nums[q]);
        if(v.size()==1){
            ans.add(-1);
            continue;
        }
        int pos=Collections.binarySearch(v,q);
        int res=Integer.MAX_VALUE;
        int left=v.get((pos-1+v.size())%v.size());
        int d1=Math.abs(q-left);
        res=Math.min(res,Math.min(d1,nums.length-d1));
        int right=v.get((pos+1)%v.size());
        int d2=Math.abs(q-right);
        res=Math.min(res,Math.min(d2,nums.length-d2));
        ans.add(res);
    }    
    return ans;
    }
}