class Solution {
    public int candy(int[] rat) {
        int n = rat.length;
        int candy = n;

        int i = 1;
        while (i < n) {
            if (rat[i - 1] == rat[i]) {
                i++;
                continue;
            }

            int peek = 0;
            while (rat[i - 1] < rat[i]) {
                peek++;
                candy += peek;
                i++;
                if (i == n) {
                    return candy;
                }
            }

            int dip = 0;
            while (i < n && rat[i - 1] > rat[i]) {
                dip++;
                candy += dip;
                i++;
            }

            candy -= Math.min(dip, peek);
        }

        return candy;
    }
}