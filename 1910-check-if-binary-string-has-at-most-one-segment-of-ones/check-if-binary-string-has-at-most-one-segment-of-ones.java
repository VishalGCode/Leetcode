class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length(), first=-1, second=-1;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                first=i;
                break;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='1'){
                second=i;
                break;
            }
        }
        for(int i=first; i<=second; i++){
            if(s.charAt(i)=='0') return false;
        }
        return true;
    }
}