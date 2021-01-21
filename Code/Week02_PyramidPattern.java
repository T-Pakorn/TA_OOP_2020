import java.util.Scanner;
/*
* Testcase from ApexTone
* 1-10
* */
public class Week02_PyramidPattern {
    public static void main(String[] args) {
        System.out.print("Enter the number of lines: ");
        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt();

        if(level<1 || level>15){
            System.out.println("Number of lines must be in range of [1-15]");
            System.exit(1);
        }

        int spaces = (level-1)*2;
        for(int i=0;i<level;i++){//level control

            for(int j=0;j<spaces;j++){//front spacing
                System.out.print(" ");
            }

            for(int j=i+1;j>1;j--){//front number (not including 1)
                System.out.print(j+" ");
            }

            for(int j=1;j<=i+1;j++){//1 to i
                System.out.print(j+" ");
            }

            System.out.println();
            spaces -= 2;
        }
    }
}