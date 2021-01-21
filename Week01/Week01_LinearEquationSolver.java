/*
* Testcase from ApexTone
* quotient = 0
* known result (3x-y=7,2x+3y=1 => 2,-1)
* */

public class Week01_LinearEquationSolver {
    public static void main(String[] args) {
        //a*d-b*c = ตัวหาร
        final double a=3.4,b=50.2,c=2.1,d=0.55,e=44.5,f=5.9;
        final double quotient = a*d-b*c;

        double x = (e * d - b * f) / quotient;
        double y = (a * f - e * c) / quotient;

        System.out.printf("x=%f y=%f\n", x, y);
    }
}
