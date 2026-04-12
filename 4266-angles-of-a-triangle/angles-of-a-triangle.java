class Solution {
    public double[] internalAngles(int[] sides) {
        double a=sides[0];
        double b=sides[1];
        double c=sides[2];
        if(a+b<=c || a+c<=b || b+c<=a) return new double[0];
        double[] res= new double[3];
        res[0]=angle(a,b,c);
        res[1]=angle(b,a,c);
        res[2]=angle(c,a,b);
        Arrays.sort(res);
        return res;    
    }
    private double angle(double a, double b, double c){
        double v=(b*b+c*c-a*a)/(2*b*c);
        v=Math.max(-1.0,Math.min(1.0,v));
        return Math.acos(v)*180.0/Math.PI;
    }
}