class Solution {
    public long smallestNumber(long num) {
        if(num==0)return 0;
        boolean isNegative=num<0;
        char[] digits=String.valueOf(Math.abs(num)).toCharArray();
        java.util.Arrays.sort(digits);
        if(isNegative){
            StringBuilder sb=new StringBuilder(new String(digits)).reverse();
            return -Long.parseLong(sb.toString());
        }else{
            int firstNonZero=0;
            while(digits[firstNonZero]=='0'){
                firstNonZero++;
            }
            char temp=digits[0];
            digits[0]=digits[firstNonZero];
            digits[firstNonZero]=temp;
            return Long.parseLong(new String(digits));
        }
    }
}