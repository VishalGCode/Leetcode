class Solution {
    public int largestAltitude(int[] gain) {
        int maxheight=0, currheight=0;
        for(int i : gain){
            currheight += i;
            maxheight = Math.max(maxheight, currheight);
        }    
        return maxheight;
    }
}