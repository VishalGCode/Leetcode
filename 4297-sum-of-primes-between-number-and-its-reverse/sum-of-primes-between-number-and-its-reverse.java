class Solution {

    // Function name must match LeetCode exactly
    public int sumOfPrimesInRange(int n) {

        // Reverse the number
        int rev = reverse(n);

        // Find range
        int start = Math.min(n, rev);
        int end = Math.max(n, rev);

        int sum = 0;

        // Check every number in range
        for (int i = start; i <= end; i++) {

            // Add if prime
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    // Reverse digits of number
    private int reverse(int n) {

        int rev = 0;

        while (n > 0) {

            rev = rev * 10 + (n % 10);

            n /= 10;
        }

        return rev;
    }

    // Prime check
    private boolean isPrime(int n) {

        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}