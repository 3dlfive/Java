package homework3;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class WeekTasks {

    static String[][] scedule = new String[][] {{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"},{"do home work","go to courses","watch a film","go to the jym","read a book","make work research","drink alcohol"}};
    static boolean gamestatus = true;
    public static void main(String[] args) {

//        String userAnswear = fistCaseUpper(askUser());
//        int arrIndex = findIndexOfCell(userAnswear,scedule[0]);
        StartGame();





    }
    static void StartGame(){
        String userAnswear = fistCaseUpper(askUser());
        int arrIndex = findIndexOfCell(userAnswear,scedule[0]);

        switch (userAnswear){
            case "Sunday", "Tuesday", "Friday", "Thursday", "Wednesday", "Monday","Saturday":
                System.out.printf(">On %2$s task os %1$s \n",scedule[1][arrIndex],scedule[0][arrIndex]);
                StartGame();
                break;
            case "Exit":
                gamestatus = false;
                break;
        }
    }
    static String askUser(){
        Scanner sc = new Scanner(System.in);
        String userInput = null;
        System.out.println("Please , input the day of the week.");
        do{
            if (userInput == null){
                userInput = sc.next();
            } else {
                System.out.printf("Sorry, I don't understand you, please try again.%s \n",userInput);
                userInput = sc.next();
            }

        }while(!(checkTwoStrings(userInput,"exit")||checkIfInTasks(userInput, scedule[0])));
//        System.out.printf("You chose %s! \n",userInput);
        return userInput;
    }
    static Boolean checkTwoStrings(String a,String b){
        return a.equalsIgnoreCase(b);
    }
    static Boolean checkIfInTasks(String input, String[] arr){
        for (String string : arr){
            if (string.equalsIgnoreCase(input)){
                return true;
            }
        }
        return false;

//        Arrays.sort(arr);
//        int res = Arrays.binarySearch(arr, input);
//        boolean result = res >= 0 ? true : false;
//        return result;
    }
    static int findIndexOfCell(String input, String[] arr){
        Arrays.sort(arr);
        int res = Arrays.binarySearch(arr,input);
        return res;
    }
    static String fistCaseUpper(String input){
        String lowerCased = input.toLowerCase();
        String[] lowedArrChars = lowerCased.split("");
        lowedArrChars[0] = lowedArrChars[0].toUpperCase(Locale.ROOT);
        return String.join("",lowedArrChars);
    }
}
