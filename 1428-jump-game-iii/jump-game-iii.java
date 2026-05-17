class Solution {
    public boolean solve(int arr[], int curr, int n, boolean visited[]) {
        if (curr < 0 || curr >= n || visited[curr]) {
            return false;
        }
        if (arr[curr] == 0) {
            return true;
        }
        visited[curr] = true;
        boolean left = solve(arr, curr - arr[curr], n, visited);
        boolean right = solve(arr, curr + arr[curr], n, visited);
        return left || right;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean visited[] = new boolean[n];
        return solve(arr, start, n, visited);
    }
}