class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        long oper=(long) k1+k2;
        int[] freq=new int[100001];
        int maxdiff=0;
        for(int i=0;i<n;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            freq[diff]++;
            maxdiff=Math.max(maxdiff,diff);
        }   
        long total=0;
        for(int d=1;d<=maxdiff;d++){
            total+=(long) d*freq[d];
        }
        if(oper>=total) return 0L;
        for(int d=maxdiff;d>0 && oper>0;d--){
            if(freq[d]==0) continue;
            long cost=(long) freq[d];
            if(oper>=cost){
                freq[d-1] += freq[d];
                oper-=cost;
                freq[d]=0;
            }else{
                freq[d]-=(int) oper;
                freq[d-1]+=(int) oper;
                oper=0;
            }
        }
        long res=0;
        for(int d=1;d<=maxdiff;d++){
            res+=(long) d*d*freq[d];
        }
        return res;
    }
}