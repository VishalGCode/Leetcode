class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        if (N == 0 || A[0].length == 0) return 0;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap();
        List<Pair<Integer, Integer>> Acoor = new ArrayList();
        List<Pair<Integer, Integer>> Bcoor = new ArrayList();
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (A[i][j] == 1) Acoor.add(new Pair(i, j));
                if (B[i][j] == 1) Bcoor.add(new Pair(i, j));
            }
        }  
        int max = 0;
        for (Pair<Integer, Integer> cA : Acoor){
            for (Pair<Integer, Integer> cB : Bcoor){
                Pair<Integer, Integer> key = new Pair(cA.getKey() - cB.getKey(), cA.getValue() - cB.getValue());
                map.put(key, map.getOrDefault(key, 0)+1);
                max = Math.max(max, map.get(key));
            }
        }
        return max;
    }
}