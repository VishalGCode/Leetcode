class Solution {
    public int minOperations(String s) {
        int mis = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) mis++;
        }
        return Math.min(mis, s.length() - mis);
    }
}