class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        for (char ch : text.toCharArray()) cnt[ch - 'a']++;
        return Math.min(cnt['b' - 'a'],
                Math.min(cnt['a' - 'a'],
                    Math.min(cnt['l' - 'a'] / 2,
                        Math.min(cnt['o' - 'a'] / 2,cnt['n' - 'a'])
                    )
                )
            );
    }
}