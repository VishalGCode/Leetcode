class Solution {
    public String getHappyString(int n, int k) {
    int t=3*(1<<(n-1));
    if(k>t) return "";
    k--;
    StringBuilder r=new StringBuilder();
    char l='\0';
    for(int pos=0;pos<n;pos++){
        int branch=1<<(n-pos-1);
        List<Character> choices=new ArrayList<>();
        for(char c:new char[]{'a','b','c'}) if(c!=l) choices.add(c);
        int idx=k/branch;
        r.append(choices.get(idx));
        l=choices.get(idx);
        k%=branch;
    }    
    return r.toString();
    }
}