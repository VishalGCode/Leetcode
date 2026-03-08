class Solution {
    public String reverseWords(String s) {
        String[] x = s.split(" ");
        for(int i=0;i<x.length;i++) x[i] = new StringBuilder(x[i]).reverse().toString();
        return String.join(" ",x);
    }
}