package homework1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] myDB = {{"1991","2001","1992"},{"When i burn?","When i go to school?","When i buy a car?"}};
        System.out.println(Arrays.deepToString(myDB));
        Random random = new Random();
        int myRandomNumber = random.nextInt(myDB[0].length);

        boolean game = true;
        System.out.println(myDB[1][myRandomNumber]);
        do {
            System.out.println("Enter the answer:");
            int userInput = Integer.parseInt(sc.nextLine());
            System.out.println("Answer is :"+ (userInput==Integer.parseInt(myDB[0][myRandomNumber])));
        } while (game);

    }
}
