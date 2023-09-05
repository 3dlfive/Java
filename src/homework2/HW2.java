package homework2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW2 {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static String[][] gameField = new String[6][6];
    static void printGameField(){
        //Method to print gamefield in console.
        String sb0 = String.join(" | ", gameField[0]);
        StringBuffer sb1 = new StringBuffer(String.join(" | ",gameField[1]));
        StringBuffer sb2 = new StringBuffer(String.join(" | ",gameField[2]));
        StringBuffer sb3 = new StringBuffer(String.join(" | ",gameField[3]));
        StringBuffer sb4 = new StringBuffer(String.join(" | ",gameField[4]));
        StringBuffer sb5 = new StringBuffer(String.join(" | ",gameField[5]));
        System.out.println(sb0 +" |");
        System.out.println(sb1 +" |");
        System.out.println(sb2+" |");
        System.out.println(sb3+" |");
        System.out.println(sb4+" |");
        System.out.println(sb5+" |");

    }
    private static void creatClearGameField(){
        //Method to creat clear gameField
        for (String[] String : gameField) Arrays.fill(String, "-");
        for (int i=0;i< gameField.length;i++){
            gameField[i][0]= String.valueOf(i);
            gameField[0][i]= String.valueOf(i);
        }

    }
    private static int[][] coordinatesOfBoat(){
        int[][] randomSecret = new int[2][3];
        switch (random.nextInt(0, 2)) {
            case 1 -> {//random array of 3 items for Column
                randomSecret[0][0] = random.nextInt(1, 4);
                randomSecret[1][0] = random.nextInt(1, 4);
                randomSecret[0][1] = randomSecret[0][0] + 1;
                randomSecret[0][2] = randomSecret[0][0] + 2;
                System.out.println("Random is 1 (column direction).");
                return randomSecret;
            }
            case 0 -> {//random array of 3 items for Raw

                randomSecret[0][0] = random.nextInt(1, 4);
                randomSecret[1][0] = random.nextInt(1, 4);
                randomSecret[1][1] = randomSecret[1][0] + 1;
                randomSecret[1][2] = randomSecret[1][0] + 2;
                System.out.println("Random is 2 (raw direction)");
                return randomSecret;
            }
            default -> {
                System.out.println("Something wrong.");
                return randomSecret;
            }
        }


    }
    private static int[] userInputWithValidation(){
        //Check input of user
        System.out.println("Player enter the number of COLUMN in range from 1-5.");
        Integer userRaw = null;
        do {
            if (!(userRaw==null)) {
                System.out.println("That's not a number in range from 1-5.");
            }
            while (!sc.hasNextInt()){
                System.out.println("That's not a number in range from 1-5");
                sc.next();
            }
            userRaw = sc.nextInt();
        } while ((!(userRaw>=1) || !(userRaw<=5)));

        //Check input of user
        Integer userColumn = null;
        System.out.println("Player enter the number of RAW in range from 1-5.");
        do {
            if (!(userColumn==null)) {
                System.out.println("That's not a number in range from 1-5.");
            }
            while (!sc.hasNextInt()){
                System.out.println("That's not a number in range from 1-5");
                sc.next();
            }
            userColumn = sc.nextInt();
        } while ((!(userColumn>=1) || !(userColumn<=5)));


        System.out.printf("You chose COLUMN: %d and RAW: %d \n",userColumn,userRaw);
        return new int[]{userColumn,userRaw};

    }
    public static void main(String[] args) {

        creatClearGameField();
        int[][] secret =coordinatesOfBoat();
        System.out.println("Secret "+ Arrays.deepToString(secret));
        printGameField();
        System.out.println("All Set. Get ready to rumble!");

        int succses_hit_counter = 0;
        boolean column,raw;

        do {
            int[] user_input = userInputWithValidation();
            column = false;
            raw = false;
            for (int s : secret[0]){
                if (s == user_input[0]){
                    System.out.println("Column correct");
                    column=!column;
                }
            }
            for (int s : secret[1]){
                if (s == user_input[1]){
                    System.out.println("Raw correct");
                    raw=!raw;
                }
            }
            if (column && raw){
                succses_hit_counter++;
                gameField[user_input[0]][user_input[1]]="*";
                printGameField();
                System.out.printf("You hit the boat, %d times.\n",succses_hit_counter);
            } else {
                gameField[user_input[0]][user_input[1]]="X";
                printGameField();
                System.out.println("You miss! Try one more time.");
            }
        } while (!(succses_hit_counter ==3));

        System.out.println("\n\nCongratulates! You win!");
//        String regex = "^[1-5]$";


    }
}
