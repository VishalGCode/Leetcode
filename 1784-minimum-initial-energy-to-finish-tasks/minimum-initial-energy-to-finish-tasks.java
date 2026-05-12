class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort tasks
        // We prioritize tasks with larger (minimum - actual) first
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        // Current energy
        int energy = 0;

        // Minimum initial energy required
        int ans = 0;

        // Process tasks
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            // If current energy is less than required minimum
            if (energy < minimum) {
                // Add extra energy needed
                ans += (minimum - energy);
                // Update current energy
                energy = minimum;
            }

            // Complete task, Energy decreases by actual cost
            energy -= actual;
        }
        return ans;
    }
}