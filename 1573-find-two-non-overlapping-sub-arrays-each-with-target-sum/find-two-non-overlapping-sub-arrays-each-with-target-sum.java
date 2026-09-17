class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] minl=new int[n];
        Arrays.fill(minl,Integer.MAX_VALUE/2);
        int l=0, sum=0;
        int ans=Integer.MAX_VALUE/2;
        int minf=Integer.MAX_VALUE/2;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            while(sum>target){
                sum-=arr[l];
                l++;
            }
            if(sum==target){
                int currlen=r-l+1;
                if(l>0){
                    ans=Math.min(ans,currlen+minl[l-1]);
                }
                minf=Math.min(minf,currlen);
            }
            minl[r]=minf;
        }     
        return ans>=Integer.MAX_VALUE/2?-1:ans;
    }
}