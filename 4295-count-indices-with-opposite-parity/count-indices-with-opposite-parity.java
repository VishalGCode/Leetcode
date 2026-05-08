class Solution {

    // Function name must match LeetCode exactly
    public int[] countOppositeParity(int[] nums) {

        int n = nums.length;

        // Answer array
        int[] ans = new int[n];

        // Count of odd and even numbers on right side
        int oddCount = 0;
        int evenCount = 0;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // If current number is even
            if (nums[i] % 2 == 0) {

                // Count odd numbers on right
                ans[i] = oddCount;

                // Increase even count
                evenCount++;
            }

            // If current number is odd
            else {

                // Count even numbers on right
                ans[i] = evenCount;

                // Increase odd count
                oddCount++;
            }
        }

        return ans;
    }
}