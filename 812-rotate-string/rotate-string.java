class Solution {
    public boolean rotateString(String s, String goal) {
        String master = s+s;
        if(s.length() != goal.length()){
            return false;
        }
        return master.contains(goal);
    }
}