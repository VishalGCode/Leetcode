class Solution {
    public double angleClock(int hour, int minutes) {
        double x=Math.abs((30*hour)-(5.5*minutes));
        return (x>180) ? 360-x : x;    
    }
}