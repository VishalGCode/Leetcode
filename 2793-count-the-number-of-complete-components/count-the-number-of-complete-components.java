class Solution {
    private int[] root, rank, edgecount;
    public int countCompleteComponents(int n, int[][] edges) {
        root=new int[n];
        rank=new int[n];
        edgecount=new int[n];
        for(int i=0; i<n; i++){
            root[i]=i;
            rank[i]=1;
            edgecount[i]=0;
        }    
        for(int[] e: edges) union(e[0],e[1]);
        int[] nodecount= new int[n];
        for(int i=0; i<n; i++) nodecount[find(i)]++;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nodecount[i] > 0){
                if(2*edgecount[i] == (nodecount[i]*(nodecount[i]-1))) cnt++;
            }
        }
        return cnt;
    }
 
    private void union(int x, int y) {
        int rx = find(x), ry = find(y); 
        int rankx = root[rx], ranky = root[ry]; 
        if(rx == ry) {
            edgecount[rx]++; 
            return; 
        }
        if(rankx > ranky) {
            root[ry] = rx; 
            edgecount[rx] += edgecount[ry] + 1; 
        } else if(ranky > rankx) {
            root[rx] = ry; 
            edgecount[ry] += edgecount[rx] + 1; 
        } else {
            root[rx] = ry; 
            edgecount[ry] += edgecount[rx] + 1; 
            rank[ry] += 1; 
        }
    }
    private int find(int x) {
        if(root[x] == x) return x; 
        return root[x] = find(root[x]);
    }
}