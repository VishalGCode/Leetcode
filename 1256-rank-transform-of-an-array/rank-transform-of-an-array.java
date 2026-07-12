class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for (int num : sorted){
            if (!map.containsKey(num)) map.put(num, r++);
        }
        for(int k=0 ; k<arr.length ; k++){
            arr[k] = map.get(arr[k]);
        }
        return arr;
    }
}