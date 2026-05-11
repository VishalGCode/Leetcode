class Solution {
    public int[] separateDigits(int[] nums) {

        // List to store final digits
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            // Convert number to string
            String s = String.valueOf(num);
            // Extract every digit
            for (char ch : s.toCharArray()) {
                // Convert character to integer digit
                list.add(ch - '0');
            }
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}