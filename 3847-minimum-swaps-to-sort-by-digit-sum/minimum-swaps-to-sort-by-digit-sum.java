class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[] digitsum=new int[n];
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++){
            digitsum[i]=getdigitsum(nums[i]);
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->{
            if(digitsum[a]!=digitsum[b]){
                return Integer.compare(digitsum[a],digitsum[b]);
            }
            return Integer.compare(nums[a],nums[b]);
        });
        boolean[] visit=new boolean[n];
        int swap=0;
        for(int i=0;i<n;i++){
            if(visit[i] || idx[i] == i) continue;
            int cycle=0;
            int curr=i;
            while(!visit[curr]){
                visit[curr]=true;
                curr=idx[curr];
                cycle++;
            }
            if(cycle>1) swap+=(cycle-1);
        }
        return swap;
    }

    private int getdigitsum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}