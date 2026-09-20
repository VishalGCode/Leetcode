class Solution {
    public int reverseDegree(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            int reverse=26-(s.charAt(i)-'a');
            int pos=i+1;
            total+=reverse*pos;
        }    
        return total;
    }
}