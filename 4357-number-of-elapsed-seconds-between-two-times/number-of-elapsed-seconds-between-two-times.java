class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return toSec(endTime) - toSec(startTime);
    }
    private int toSec(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }
}