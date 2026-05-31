class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long c = mass;
        for(int i=0; i<n; i++){
            if(c<asteroids[i]) return false;
            c+=asteroids[i];
        }    
        return true;
    }
}