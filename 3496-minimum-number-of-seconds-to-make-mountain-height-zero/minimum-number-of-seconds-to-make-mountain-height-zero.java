class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left=1, right=(long)1e18;
        while(left<right){
            long mid=left+(right-left)/2;
            if(finish(mid, mountainHeight, workerTimes)) right=mid;
            else left=mid+1;
        }
        return left;
    }
    private boolean finish(long time, int height, int[] workers){
        long total=0;
        for(int w:workers){
            long x = (long)((Math.sqrt(1+8.0*time/w)-1)/2);
            total += x;
            if (total>=height) return true;
        }
        return false;
    }
}