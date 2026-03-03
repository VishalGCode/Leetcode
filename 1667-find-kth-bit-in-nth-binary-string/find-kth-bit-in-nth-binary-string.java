class Solution {
    public char findKthBit(int n, int k) {
        int flips = 0;
        while (k > 1) {
            if ((k & (k - 1)) == 0) return (flips % 2 == 0) ? '1' : '0';
            int highestPower = Integer.highestOneBit(k);
            k = highestPower * 2 - k;
            flips++;
        }
        return (flips % 2 == 0) ? '0' : '1';
    }
}