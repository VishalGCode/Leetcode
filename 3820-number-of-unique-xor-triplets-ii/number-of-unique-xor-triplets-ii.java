class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max=0;
        for(int num:nums) max = Math.max(max, num);
        int maxLimit=1;
        while(maxLimit <= max) maxLimit <<= 1;
        maxLimit <<= 1; 
        boolean[] Num = new boolean[maxLimit];
        int uniqueCount = 0;
        for (int num : nums) {
            if (!Num[num]) {
                Num[num] = true;
                uniqueCount++;
            }
        }
        int[] uniqueNums = new int[uniqueCount];
        int idx = 0;
        for (int i=0;i<maxLimit;i++) if (Num[i]) uniqueNums[idx++] = i;
        boolean[] hasPairXor = new boolean[maxLimit];
        for (int i = 0; i < uniqueCount; i++) {
            for (int j = i; j < uniqueCount; j++) {
                hasPairXor[uniqueNums[i] ^ uniqueNums[j]] = true;
            }
        }
        int pairCount = 0;
        for(boolean present:hasPairXor) if(present) pairCount++;
        int[] pairs = new int[pairCount];
        idx = 0;
        for (int i = 0; i < maxLimit; i++) if (hasPairXor[i]) pairs[idx++] = i;
        boolean[] hasTripletXor = new boolean[maxLimit];
        int resultCount = 0;
        for (int p:pairs){
            for (int num:uniqueNums){
                int tripletXor=p^num;
                if (!hasTripletXor[tripletXor]) {
                    hasTripletXor[tripletXor]=true;
                    resultCount++;
                }
            }
        }
        return resultCount;
    }
}