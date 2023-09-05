package homework2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW2 {
    static Random random = new Random();

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        creatClearGameField();
        System.out.println("Secret "+Arrays.deepToString(coordinatesOfBoat()));
        printGameField();
        System.out.println("All Set. Get ready to rumble!");


//        String regex = "^[1-5]$";
        //Check input of user
        Integer userColumn = null;
        System.out.println("Player enter the number of column in range from 1-5.");
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

        //Check input of user
        System.out.println("Player enter the number of raw in range from 1-5.");
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
        System.out.printf("You chose column: %d and raw: %d",userColumn,userRaw);




    }
}
