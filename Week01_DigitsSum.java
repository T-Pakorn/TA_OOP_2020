import java.util.InputMismatchException;
import java.util.Scanner;
/*
* Testcase from ApexTone
* input < 0 or input > 1000
* input as float, string
* */

public class Week01_DigitsSum {
    //left-most = 0, right-most = length-1
    public static int getDigit(Integer number, int index){
        if(index < 0 || index>number.toString().length()-1){
            System.out.println("Out of bound");
            return -1;
        }
        int div = (int)Math.pow(10.0, index);
        return (number/div) % 10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        Integer input = 0;
        try {
            input = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.err.println("Only accept an integer");
            System.exit(0);
        }

        if(input < 0 || input > 1000){
            System.out.println("Value out of bound (0-1000)");
        }
        else {
            int sum = 0;
            for (int i = 0; i < input.toString().length(); i++) {
                int buffer = getDigit(input, i);
                sum += buffer;
            }
            System.out.printf("The sum of the digits is %d", sum);
        }
    }
}
    
