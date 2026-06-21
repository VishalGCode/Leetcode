class Solution {
    public int maxDistance(String moves) {
    int x=0, y=0, z=0;
        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i)
            ;
            switch (ch) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'L' -> x--;
                case 'R' -> x++;
                default  -> z++;
            }
        }
        return Math.abs(x)+Math.abs(y)+z;    
    }
}