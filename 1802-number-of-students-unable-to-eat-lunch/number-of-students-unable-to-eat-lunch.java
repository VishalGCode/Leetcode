class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int c_sand=0;
        int s_sand=0;
        for(int choice:students){
            if(choice==0) c_sand++;
            else s_sand++;
        }
        for(int sandwich:sandwiches){
            if(sandwich==0 && c_sand==0) return s_sand;
            if(sandwich==1 && s_sand==0) return c_sand;
            if(sandwich==0) c_sand--;
            else s_sand--;
        }
        return 0;
    }
}