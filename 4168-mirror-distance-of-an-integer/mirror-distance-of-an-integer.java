class Solution {
    public int mirrorDistance(int n) {
        return (int) Math.abs(n - rev(n));
    }

    private int rev(int n) {
        long sum = 0;
        while (n > 0) {
            sum = sum * 10 + n % 10;
            n /= 10;
        }
        return (int) sum;
    }
}