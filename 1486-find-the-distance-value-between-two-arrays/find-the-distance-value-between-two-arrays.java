class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Arrays.sort(arr2);
        // int l=0;
        // int maxcount=0;
        // int h=arr2.length-1;
        // while(l<h){
        //     int mid=l+(h-l)/2;
        //     if(mid<d){
        //         for(int i=mid+1;i<arr2.length;i++){
        //             for(int j=0;j<arr1.length;j++){
        //                 if(Math.abs(arr1[j]-arr2[i]) <= d) maxcount++;
        //             }
        //         }
        //     }else if(mid>d){
        //         for(int i=0;i<mid;i++){
        //             for(int j=0;j<arr1.length;j++){
        //                 if(Math.abs(arr1[j]-arr2[i]) <= d) maxcount++;
        //             }
        //         }
        //     }
        // }
        int maxcount=0;
        for(int i=0;i<arr1.length;i++){
            boolean isvalid=true;
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j]) <= d){
                    isvalid=false;
                    break;
                }
            }
        if(isvalid) maxcount++;
        }
        return maxcount;
    }
}