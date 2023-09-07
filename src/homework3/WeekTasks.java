package homework3;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class WeekTasks {
    static Scanner sc = new Scanner(System.in);
    static String[][] scedule = new String[][] {{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"},{"do home work","go to courses","watch a film","go to the jym","read a book","make work research","drink alcohol"}};
    static boolean gamestatus = true;
    public static void main(String[] args) {

        String menuInfo = """
                 ------------------------- MENU -----------------------------------------
                | I am glad to welcome you to our diary program.                          |
                | You can set the day of the week to find out the task for that day.      |
                | Example: Sunday,Monday                                                  |
                | you can also change the task for the day using the "change DAY" command.|
                 ------------------------------------------------------------------------
                """;
        System.out.println(menuInfo);
        StartGame();





    }
    static void StartGame(){
        String userAnswear = fistCaseUpper(askUser());
        int arrIndex = findIndexOfCell(userAnswear,scedule[0]);
        String[] user_splited_answear = userAnswear.split(" ");
        String user_want_change_date = "";
        if (user_splited_answear.length==2){
            user_want_change_date = fistCaseUpper(user_splited_answear[1]);
        }
        switch (userAnswear){
            case "Sunday", "Tuesday", "Friday", "Thursday", "Wednesday", "Monday","Saturday":
                System.out.printf(">On %2$s task is --> %1$s .\n\n",scedule[1][arrIndex],scedule[0][arrIndex]);
                StartGame();
                break;
            case "Exit":
                gamestatus = false;
                break;
            default:
                switch (user_want_change_date){
                    case "Sunday", "Tuesday", "Friday", "Thursday", "Wednesday", "Monday","Saturday":
                        System.out.printf("Please, input new tasks for %s .\n", user_want_change_date);
                        String newTask = sc.nextLine();
                        int indexOfCell = findIndexOfCell(user_want_change_date,scedule[0]);
                        scedule[1][indexOfCell]=newTask;
                        break;
                    default:
                        System.out.println(user_want_change_date);
                        System.out.println("Kiev we got problem. input was:"+user_want_change_date);

                }
                StartGame();
        }
    }
    static String askUser(){

        String userInput = null;
        System.out.println("Please , input the day of the week.");
        do{
            if (userInput == null){
                userInput = sc.nextLine();
            } else {
                System.out.printf("Sorry, I don't understand you, please try again.%s \n",userInput);
                userInput = sc.nextLine();
            }
        }while(!(checkTwoStrings(userInput,"exit")||checkIfInTasks(userInput, scedule[0])||checkifHaveWordCHange(userInput)));
//        System.out.printf("You chose %s! \n",userInput);
        String[] tempString = userInput.split(" ",0);
        if (tempString.length==1){
            return userInput.replace(" ","");
        } else {
            return userInput;
        }

    }
    static boolean checkifHaveWordCHange(String str){
        String[] tempString = str.split(" ",0);
        if (tempString.length == 2) {
            if ((Objects.equals(tempString[0], "change") && checkIfInTasks(tempString[1], scedule[0]))) {
                return true;
            }
        }
        return false;
    }
    static Boolean checkTwoStrings(String a,String b){
        return a.equalsIgnoreCase(b);
    }
    static Boolean checkIfInTasks(String input, String[] arr){
//        need to remove space
        for (String string : arr){
            if (string.equalsIgnoreCase(input.replace(" ",""))){
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
