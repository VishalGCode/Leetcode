class Solution {
    public String lexGreaterPermutation(String s,String target){
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int n=s.length();
        for(int prefixLen=n;prefixLen>=0;prefixLen--){
            int[] curFreq=freq.clone();
            boolean possible=true;
            for(int i=0;i<prefixLen;i++){
                int charIdx=target.charAt(i)-'a';
                if(curFreq[charIdx]>0){
                    curFreq[charIdx]--;
                }else{
                    possible=false;
                    break;
                }
            }
            if(!possible)continue;
            if(prefixLen==n)continue;

            int pivotChar=-1;
            int targetCharIdx=target.charAt(prefixLen)-'a';
            for(int c=targetCharIdx+1;c<26;c++){
                if(curFreq[c]>0){
                    pivotChar=c;
                    break;
                }
            }
            if(pivotChar==-1)continue;

            curFreq[pivotChar]--;
            StringBuilder res=new StringBuilder();
            res.append(target.substring(0,prefixLen));
            res.append((char)('a'+pivotChar));
            for(int c=0;c<26;c++){
                while(curFreq[c]>0){
                    res.append((char)('a'+c));
                    curFreq[c]--;
                }
            }
            return res.toString();
        }
        return "";
    }
}