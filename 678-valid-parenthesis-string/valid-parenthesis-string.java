class Solution {
    public boolean checkValidString(String s) {
        int openc=0, closec=0, length=s.length()-1;
        for(int i=0;i<=length;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*') openc++;
            else openc--;
            if(s.charAt(length-i)==')' || s.charAt(length-i)=='*') closec++;
            else closec--;
            if(openc<0 || closec<0) return false;
        }    
        return true;
    }
}