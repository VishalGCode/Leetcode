class Solution {
    public boolean sumGame(String num) {
        int len=num.length();
        int leftSum=0,rightSum=0;
        int leftQ=0,rightQ=0;

        for(int i=0;i<len/2;i++){
            if(num.charAt(i)=='?') leftQ++;
            else leftSum+=num.charAt(i)-'0';
        }
        for(int i=len/2;i<len;i++){
            if(num.charAt(i)=='?') rightQ++;
            else rightSum+=num.charAt(i)-'0';
        }
        if((leftQ+rightQ)%2!=0)return true;
        int sumDiff=leftSum-rightSum;
        int qDiff=rightQ-leftQ;
        return sumDiff*2!=qDiff*9;
    }
}