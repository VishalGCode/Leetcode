class Solution {
    List<Integer>[] adj;
    int[] parent,depth,tin,tout,baseprefix,bit;
    int[][] up;
    int timer;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        char[] chars=s.toCharArray();
        parent=new int[n];
        depth=new int[n];
        tin=new int[n];
        tout=new int[n];
        baseprefix=new int[n];
        timer=0;
        parent[0]=0;
        baseprefix[0]= 1 << (chars[0] - 'a');
        int[] stack=new int[2*n+5];
        int top=0;
        stack[top++]=0;
        while(top > 0){
            int x=stack[--top];
            if(x<0){
                int u=~x;
                tout[u]=timer-1;
                continue;
            }
            int u=x;
            tin[u]=timer++;
            stack[top++]=~u;
            for(int i=adj[u].size()-1;i>=0;i--){
                int v=adj[u].get(i);
                if(v==parent[u]) continue;
                parent[v]=u;
                depth[v]=depth[u]+1;
                baseprefix[v]=baseprefix[u]^(1<<(chars[v]-'a'));
                stack[top++]=v;
            }
        }
        int log=1;
        while((1<<log)<=n){
            log++;
        }
        up=new int[log][n];
        for(int i=0;i<n;i++){
            up[0][i]=parent[i];
        }
        for(int k=1;k<log;k++){
            for(int i=0;i<n;i++){
                up[k][i]=up[k-1][up[k-1][i]];
            }
        }
        bit=new int[n+2];
        List<Boolean> ans=new ArrayList<>();
        for(String q:queries){
            String[] parts=q.split("\\s+");
            if(parts[0].equals("update")){
                int u=Integer.parseInt(parts[1]);
                char c=parts[2].charAt(0);
                int oldmask=1<<(chars[u]-'a');
                int newmask=1<<(c-'a');
                int delta=oldmask^newmask;
                updatebit(tin[u]+1,delta);
                updatebit(tout[u]+2,delta);
                chars[u]=c;
            }else{
                int u=Integer.parseInt(parts[1]);
                int v=Integer.parseInt(parts[2]);
                int lca=findlca(u,v);
                int prefixu=baseprefix[u]^querybit(tin[u]+1);
                int prefixv=baseprefix[v]^querybit(tin[v]+1);
                int pathmask=prefixu^prefixv^(1<<(chars[lca]-'a'));
                ans.add((pathmask & (pathmask-1))==0);
            }
        }
        return ans;
    }
    private int querybit(int idx){
        int result=0;
        while(idx>0){
            result^=bit[idx];
            idx-=idx & -idx;
        }
        return result;
    }
    private void updatebit(int idx,int delta){
        while(idx<bit.length){
            bit[idx]^=delta;
            idx+=idx & -idx;
        }
    }
    private int findlca(int u,int v){
        if(depth[u]<depth[v]){
            int temp=u;
            u=v;
            v=temp;
        }
        int diff=depth[u]-depth[v];
        for(int k=up.length-1;k>=0;k--){
            if(((diff>>k) & 1) == 1) u=up[k][u];
        }
        if(u==v) return u;
        for(int k=up.length-1;k>=0;k--){
            if(up[k][u] != up[k][v]){
                u=up[k][u];
                v=up[k][v];
            }
        }
        return parent[u];
    }
}