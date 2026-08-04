class Solution {
    public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int radius=0,i=0;
    int left, right;
    for(int house:houses){
        while(i<heaters.length-1 && heaters[i]<=house){
            i++;
        }
        left=Math.abs(house-(i>0?heaters[i-1]:heaters[0]));
        right=Math.abs(heaters[i]-house);
        radius=Math.max(radius, Math.min(left,right));
    }    
    return radius;
    }
}