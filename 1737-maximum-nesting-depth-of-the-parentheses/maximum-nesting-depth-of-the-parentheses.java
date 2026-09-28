class Solution {
    public int maxDepth(String s) {
        int curr=0;
        int maxd=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                curr++;
                maxd=Math.max(maxd,curr);
            }else if(c==')') curr--;
        }    
        return maxd;
    }
}