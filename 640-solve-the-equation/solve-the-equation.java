class Solution {
    public String solveEquation(String equation) {
    String[] sides=equation.split("=");
    int[] lhsres=parse(sides[0]);
    int[] rhsres=parse(sides[1]);

    //consolidate coefficients of x and constants
    int xcoeff=lhsres[0]-rhsres[0];
    int constant=rhsres[1]-lhsres[1];
    if(xcoeff==0){
        if(constant==0) return "Infinite solutions";
        else return "No solution";
    }else return "x="+(constant/xcoeff);
    }

    private int[] parse(String expression){
        int coeff=0;
        int total=0;
        int sign=1;
        int num=0;
        boolean hasNum=false;
        for(int i=0;i<=expression.length();i++){
            char c=i<expression.length()?expression.charAt(i):'+';
            if(c=='+' || c=='-'){
                if(hasNum){
                    total+=sign*num;
                    num=0;
                    hasNum=false;
                }
                sign=(c=='+')?1:-1;
            }else if(Character.isDigit(c)){
                num=num*10+(c-'0');
                hasNum=true;
            }else if(c=='x') {
                if(!hasNum) coeff+=sign*1;
                else{
                    coeff+=sign*num;
                    num=0;
                    hasNum=false;
                }
            }
        }
        return new int[]{coeff,total};
    }
}