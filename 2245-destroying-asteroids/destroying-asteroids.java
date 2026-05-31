class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long c = mass;
        for(int ast:asteroids){
            if(c<ast) return false;
            c+=ast;
        }    
        return true;
    }
}