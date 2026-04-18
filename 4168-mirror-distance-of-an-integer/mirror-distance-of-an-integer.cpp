class Solution {
public:
    int rev(int n) {
        int sum = 0;
        while (n > 0) {
            sum = (sum * 10) + (n % 10);
            n /= 10;
        }
        return sum;
    }
    int mirrorDistance(int n) { return abs(n - rev(n)); }
};