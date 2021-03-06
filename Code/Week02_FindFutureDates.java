import java.util.Scanner;

/*
* Testcase from ApexTone
* Invalid startDate day
* Invalid elapsed days
* */

public class Week02_FindFutureDates {
    public static void main(String[] args) {
        int startDate, elapsed;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Enter today's day: ");
            startDate = scanner.nextInt();
            if(startDate<0 || startDate>6){
                System.out.println("Invalid day of a week (0-6)\n");
                continue;
            }

            System.out.print("Enter the number of days elapsed since today: ");
            elapsed = scanner.nextInt();
            if(elapsed <= 0){
                System.out.println("Invalid future days\n");
                continue;
            }

            System.out.printf("Today is %s and the future day is %s\n\n", intToDay(startDate), intToDay((startDate + elapsed) % 7));

        }
    }

    public static String intToDay(int number){
        String day;

        switch(number){
            case 0: day="Sunday"; break;
            case 1: day="Monday"; break;
            case 2: day="Tuesday"; break;
            case 3: day="Wednesday"; break;
            case 4: day="Thursday"; break;
            case 5: day="Friday"; break;
            case 6: day="Saturday"; break;
            default: day="UNIDENTIFIED";
        }

        return day;
    }
}

















