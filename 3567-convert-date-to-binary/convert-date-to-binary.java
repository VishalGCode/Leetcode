class Solution {
    public String convertDateToBinary(String date) {
    int year=0;
    for(int i=0;i<4;i++){
        year=year*10+(date.charAt(i)-'0');
    }    
    int month=(date.charAt(5)-'0')*10+(date.charAt(6)-'0');
    int day=(date.charAt(8)-'0')*10+(date.charAt(9)-'0');
    return new StringBuilder().append(Integer.toBinaryString(year)).append('-').append(Integer.toBinaryString(month)).append('-').append(Integer.toBinaryString(day)).toString();
    }
}