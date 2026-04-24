class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count = 0, x = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') count--;
            else if (c == 'R') count++;
            else x++;
        }
        return Math.abs(count) + x;
    }
}