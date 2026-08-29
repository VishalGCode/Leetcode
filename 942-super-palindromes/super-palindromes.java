class Solution {
    public int superpalindromesInRange(String left, String right) {
    long l=Long.parseLong(left);
    long r=Long.parseLong(right);
    int count=0;
    int limit=100000;

    //ODD LENGTH PALINDROME CALCULATE
    for(int i=1;i<limit;i++){
        String s=Integer.toString(i);
        StringBuilder sb=new StringBuilder(s);
        for(int j=s.length()-2;j>=0;j--) sb.append(s.charAt(j));
        long k=Long.parseLong(sb.toString());
        long sq=k*k;
        if(sq>r) break;
        if(sq>=l && isPalindrome(sq)) count++;
    }    
    // EVEN LENGTH PALINDROME CALCULATE
    for(int i=1;i<limit;i++){
        String s=Integer.toString(i);
        StringBuilder sb=new StringBuilder(s);
        for(int j=s.length()-1;j>=0;j--) sb.append(s.charAt(j));
        long k=Long.parseLong(sb.toString());
        long sq=k*k;
        if(sq>r) break;
        if(sq>=l && isPalindrome(sq)) count++;
    }
    return count;
    }
  
    // PALINDROME CHECK
    private boolean isPalindrome(long num){
        String s=Long.toString(num);
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}