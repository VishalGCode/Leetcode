class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid.length;j++){
                sb.append(grid[i][j]).append('#');
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }    
        int res=0;
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid.length;j++){
                sb.append(grid[j][i]).append('#');
            }
            res += map.getOrDefault(sb.toString(),0);
        }
        return res;
    }
}