class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length;
        int m=tasks.length;
        int[] ans=new int[m];
        PriorityQueue<int[]> fserver=new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        PriorityQueue<int[]> bserver=new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            if(a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[2],b[2]);
        });
        for(int i=0;i<n;i++){
            fserver.add(new int[]{servers[i],i});
        }    
        int currtime=0;
        for(int j=0;j<m;j++){
            currtime=Math.max(currtime,j);
            if(fserver.isEmpty()) currtime=Math.max(currtime,bserver.peek()[0]);
            while(!bserver.isEmpty() && bserver.peek()[0]<=currtime){
                int[] server=bserver.poll();
                fserver.add(new int[]{server[1],server[2]});
            }
            int[] choose=fserver.poll();
            int weight=choose[0];
            int idx=choose[1];
            ans[j]=idx;
            bserver.add(new int[]{currtime+tasks[j],weight,idx});
        }
        return ans;
    }
}
