class Solution {
    public int[] separateDigits(int[] arr) {
        // Store total number of digits
        int totalDigits = 0;

        //Count total digits
        for (int n : arr) {
            int temp = n;

            // Special case for 0
            if (temp == 0) totalDigits++;
            else {
                // Count digits one by one
                while (temp > 0) {
                    totalDigits++;
                    // Remove last digit
                    temp /= 10;
                }
            }
        }

        // Final answer array
        int[] ans = new int[totalDigits];
        //Start filling from end
        int index = totalDigits - 1;
        //Traverse array backwards
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            // Handle 0 separately
            if(num == 0) ans[index--] = 0;
            else{
                // Extract digits from right to left
                while (num > 0) {
                    // Store last digit
                    ans[index--] = num % 10;
                    // Remove last digit
                    num /= 10;
                }
            }
        }
        return ans;
    }
}