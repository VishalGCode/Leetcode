class Solution {
    public long minMoves(int[] balance) {
        int n=balance.length;
        int neg=-1;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=balance[i];
            if(balance[i]<0) neg=i;
        }
        if(neg==-1) return 0;
        if(sum<0) return -1;
        long need=-balance[neg];
        List<long[]> candidate=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i==neg) continue;
            if(balance[i]>0){
                long dist=Math.min(Math.abs(i-neg),n-Math.abs(i-neg));
                candidate.add(new long[]{dist,balance[i]});
            }
        }
        candidate.sort((a,b)->Long.compare(a[0],b[0]));
        long total=0;
        for(long[] item:candidate){
            long dist=item[0];
            long avail=item[1];
            long take=Math.min(need,avail);
            total+=take*dist;
            need-=take;
            if(need==0) break;
        }
        return total;
    }
}