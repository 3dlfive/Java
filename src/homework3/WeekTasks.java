package homework3;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class WeekTasks {

    static String[][] scedule = new String[][] {{"Sunday","Monday","Thursday","Wednesday","Thursday","Friday","Saturday","Sunday"},{"do home work","go to courses","watch a film","go to the jym","read a book","make work research","drink alcohol"}};
    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(scedule[0]));
        String userInput ;
        askUser();


    }
    static String askUser(){
        Scanner sc = new Scanner(System.in);
        String userInput;
        System.out.println("Please , input the day of the week.");
        do{

           System.out.println("Enter the write day:");
            userInput = sc.next();

        }while(!checkIfInTasks(userInput, scedule[0]));
        System.out.printf("You chose %s!",userInput);
        return userInput;
    }
    static Boolean checkIfInTasks(String input, String[] arr){
        Arrays.sort(arr);
        int res = Arrays.binarySearch(arr, input);
        boolean result = res >= 0 ? true : false;
        return result;
    }
}
