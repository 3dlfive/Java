package homework1;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class HW1 {

    public static void main(String[] args) {
        // Random numbers [0-100]
        Random random = new Random();
        int randNumber = random.nextInt(101);
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String username = scanner.next();
        String gameMenu = """
                Chose game mode:
                1. Simple;
                2. Advance;
                """;

        System.out.println(gameMenu);


        while (!scanner.hasNextInt() ){ // How to check for !1 and !2 , these condition dont work --> && scanner.nextInt()!=1 && scanner.nextInt()!=2
            System.out.println("Invalid choose.");
            scanner.next();
        }
        int gameChoose = scanner.nextInt();


        System.out.println(gameChoose);
        System.out.println("Let the game begin!");
        System.out.println(randNumber);
        boolean game = true;
        int[] intArray = new int[0];

        do {
            System.out.println("\nEnter the number:");
            int userNumber;
//            validate input

            while (!scanner.hasNextInt()){
                System.out.println("Thats not a number");
                scanner.next();
            }
            userNumber = scanner.nextInt();

//          Increase size of array and end to the end value.
            intArray = Arrays.copyOf(intArray,intArray.length+1);
            intArray[intArray.length-1] = userNumber;

            if (userNumber < randNumber) System.out.println("Your number is too small. Please, try again.");
            if (userNumber > randNumber) System.out.println("Your number is too big. Please, try again.");
            if (userNumber == randNumber) {
                System.out.printf("Congratulations, %s! \n", username);
                game = false;
                System.out.println("Your numbers:");
                Arrays.sort(intArray);
                System.out.println(Arrays.toString(intArray));
                System.out.printf("Game over. Correct number is % -5d =>\nprogram closed.",randNumber);
            }
        } while (game);

   }
}
