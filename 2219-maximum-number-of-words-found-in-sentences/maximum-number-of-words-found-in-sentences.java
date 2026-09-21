class Solution {
    public int mostWordsFound(String[] sentences) {
        int count=1;
        for(String s:sentences){
            int sp=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==' ') sp++;
            }
            count=Math.max(count,sp+1);
        }
        return count;
    }    
}
