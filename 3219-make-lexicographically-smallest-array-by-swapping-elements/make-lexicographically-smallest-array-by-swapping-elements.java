class Solution {
    public int[] lexicographicallySmallestArray(int[] nums,int limit){
        int n=nums.length;
        int[][] sorted=new int[n][2];
        for(int i=0;i<n;i++){
            sorted[i][0]=nums[i];
            sorted[i][1]=i;
        }
        Arrays.sort(sorted,(a,b)->Integer.compare(a[0],b[0]));

        int[] result=new int[n];
        int i=0;
        while(i<n){
            int j=i;
            List<Integer> indices=new ArrayList<>();
            indices.add(sorted[i][1]);
            while(j+1<n&&sorted[j+1][0]-sorted[j][0]<=limit){
                j++;
                indices.add(sorted[j][1]);
            }
            Collections.sort(indices);
            for(int k=0;k<indices.size();k++){
                result[indices.get(k)]=sorted[i+k][0];
            }
            i=j+1;
        }
        return result;
    }
}