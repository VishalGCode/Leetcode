class Solution {
    public int minimumCost(int[] cost) {
    Arrays.sort(cost);
    int diff=0, res=0;
    for(int i=cost.length-1;i>=0;i--){
        if(res==2){
            res=0;
            continue;
        }else{
            res++;
        }
        diff += cost[i];
    }  
    return diff;
    }
}