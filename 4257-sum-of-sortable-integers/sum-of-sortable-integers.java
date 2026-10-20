class Solution {
    public int sortableIntegers(int[] nums) {
        int[] sorted=nums.clone();
        int res=0, cur=-1;
        Arrays.sort(sorted);
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(nums.length%i==0) list.add(i);
        }    
        for(int d:list){
            boolean flag=false;
            for(int i=0;i<nums.length;i+=d){
                int[] arr=new int[d];
                int ind=0;
                for(int j=i;j<i+d;j++){
                    arr[ind++]=nums[j];
                }
                int piv=findpivot(arr);
                if(piv==-2) flag=true;
                if(flag) break;
                Arrays.sort(arr);
                for(int f=0;f<arr.length;f++){
                    if(arr[f]!=sorted[i+f]) flag=true;
                }
                if(flag) break;
            }
            if(!flag) res+=d;
        }
        return res;
    }

    public int findpivot(int[] nums){
        int n=nums.length;
        int pivot=-1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                if(pivot!=-1) return -2;
                pivot=i;
            }
        }
        if(pivot!=-1 && nums[n-1]>nums[0]) return -2;
        return pivot;
    }
}