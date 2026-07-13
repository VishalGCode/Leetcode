class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> res = new ArrayList<>();
    String digits = "123456789";
    int lowLen =  String.valueOf(low).length();
    int highLen = String.valueOf(high).length();
    for(int length = lowLen; length<=highLen; length++){
        for(int start=0; start<=9-length; start++){
            String sub = digits.substring(start, start+length);
            int num = Integer.parseInt(sub);
            if(num>=low && num<=high)
                res.add(num);
        }
    }    
    return res;
    }
}