class Solution {
    public int numSub(String s) {
    long total=0;
    long count=0;
    long mod=1000000007;
    for(char c: s.toCharArray()){
        if(c=='1'){
            count++;
            total=(total+count)%mod;
        }else count=0;
    }    
    return (int) total;
    }
}