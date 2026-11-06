class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m=queries.length;
        int[][] sortq=new int[m][2];
        for(int i=0;i<m;i++){
            sortq[i][0]=queries[i];
            sortq[i][1]=i;
        }
        Arrays.sort(sortq, Comparator.comparingInt(a->a[0]));
        Arrays.sort(logs, Comparator.comparingInt(a->a[1]));
        int[] ans=new int[m];
        int[] servercount=new int[n+1];
        int activeserver=0;
        int left=0, right=0;
        for(int i=0;i<m;i++){
            int qtime=sortq[i][0];
            int origidx=sortq[i][1];
            int windowstart=qtime-x;
            int windowend=qtime;
            while(right<logs.length && logs[right][1]<= windowend){
                int serverid=logs[right][0];
                if(servercount[serverid]==0) activeserver++;
                servercount[serverid]++;
                right++;
            }
            while(left<logs.length && logs[left][1] < windowstart){
                int serverid=logs[left][0];
                servercount[serverid]--;
                if(servercount[serverid]==0) activeserver--;
                left++;
            }
            ans[origidx]=n-activeserver;
        }
        return ans;
    }
}
