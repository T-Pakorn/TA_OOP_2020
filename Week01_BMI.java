import java.util.Scanner;

/*
* Testcase
* height, weight <= 0
* input as number
* floating point precision (input 95.5,50 => output 26.8573)
* */

public class Week01_BMI {
    public static double BMI(double weight,double height) {
        final double pounds = 0.45359237;
        final double inches = 0.0254;
        return (weight*pounds) / (height*inches*height*inches);
    }
    
    public static void main(String[] args) {
        double weight,height;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        weight = scanner.nextDouble();
        if(weight <= 0){
            System.err.println("Weight must be positive");
            System.exit(0);
        }

        System.out.print("Enter height in inches: ");
        height = scanner.nextDouble();
        if(height <= 0){
            System.err.println("Height must be positive");
            System.exit(0);
        }

        System.out.println("BMI is " + String.format("%.4f",BMI(weight, height)));
    }
}
