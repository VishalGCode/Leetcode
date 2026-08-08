class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        int j = m - 1;
        for(int i = n - 1; i >= 0 && j >= 0; i--) {
            if(word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }
        int[] res = new int[m];
        boolean c = false;
        j = 0;
        for(int i = 0; i < n && j < m; i++) {
            boolean isMatch = word1.charAt(i) == word2.charAt(j);
            boolean canMismatch=!c && (j == m-1 || last[j+1]>i);
            if (isMatch || canMismatch) {
                if(!isMatch) c = true;
                res[j] = i;
                j++;
            }
        }
        return j==m?res:new int[0];
    }
}