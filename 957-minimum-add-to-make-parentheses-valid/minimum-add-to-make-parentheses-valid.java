class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int cnt=0;
        int ans=0;
        for(char c:s.toCharArray()){
            if(c=='(') cnt++;
            else cnt--;
            if(cnt==-1){
                ans++;
                cnt=0;
            }
        }  
        ans+=Math.abs(cnt);
        return ans;
    }
}