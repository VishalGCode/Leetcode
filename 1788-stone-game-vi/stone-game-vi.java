class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
    int n= aliceValues.length, res=0, bsum=0, cnt=0;
    var arr= new int[201];
    for(int i=0;i<n;i++){
        int b=bobValues[i];
        arr[aliceValues[i]+b]++;
        bsum+=b;
    }    
    for(int i=200;i>-1;i--){
        int sum=arr[i];
        while(sum-- > 0) if((cnt++ & 1)==0) res+=i;
    }
    return res>bsum?1:res<bsum?-1:0;
    }
}