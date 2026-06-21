class Solution {
    public int maxDistance(String moves) {
        int x = 0, y = 0, z = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'L') x--;
            else if (ch == 'R') x++;
            else if (ch == '_') z++;
        }

        return Math.abs(x) + Math.abs(y) + z;
    }
}