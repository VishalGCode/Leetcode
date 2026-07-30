class Solution {
    public int minimumPushes(String word) {
    int n=word.length();
    if(n<=8) return n;
    int count=0, j=0;
    for(int i=0;i<n;i++){
        if(i%8==0) j++;
        count+=j;
    }    
    return count;
    }
}