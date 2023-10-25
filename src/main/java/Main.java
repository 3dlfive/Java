import homework6.dao.CollectionFamilyDao;
import homework6.dao.FamilyController;
import homework6.dao.FamilyService;
import homework6.family.Family;
import homework6.human.Human;
import homework6.human.Men;
import homework6.human.Women;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        FamilyController appController = new FamilyController(new FamilyService(new CollectionFamilyDao()));


        while (true) {
            startFamService();
            int userinput = askUserMainM(1, 9);
            mainMenu(appController, userinput);

        }

    }

    static void mainMenu(FamilyController appController, int userinput) {
        switch (userinput) {
            case 1:
                appController.generateFam();
                break;
            case 2:
                appController.displayAllFamilies();
                break;
            case 3:
                System.out.println("--Меню Відобразити список сімей, де кількість людей більша за задану");
                System.out.printf("Виберіть число до %s \n", appController.count());
                appController.getFamiliesBiggerThan(askUserMainM(1, appController.count()));
                break;
            case 4:
                System.out.printf("Виберіть число до %s \n", appController.count());
                appController.getFamiliesLessThan(askUserMainM(1, appController.count()));
                break;
            case 5:
                System.out.println("--Меню Підрахувати кількість сімей \n");

                System.out.println(appController.count());
                break;
            case 6:

                System.out.println("--Меню Створення нової родини \n");
                createFamily(appController);

                System.out.println(appController.count());
                break;
            case 7:
                System.out.println("--Меню Видалення родини\n");
                System.out.printf("\nВиберіть число до %s\n", appController.count());
                appController.deleteByIndex(askUserMainM(1, appController.count()));
                break;
            case 8:
                //Нужно доделать
                System.out.println("--Меню зміна сімї за індексом");
                String submenu2 = """
                        - 1. Народити дитину
                        - 2. Усиновити дитину
                        - 3. Повернутися до головного меню
                         """;
                System.out.println(submenu2);
                int userinputSM = askUserMainM(1, 3);
                switch (userinputSM) {
                    case 1:
                        System.out.println("--Введіть дівоче імя");
                        String girlname = askUserString();
                        System.out.println("--Введіть чоловіче імя");
                        String bouname = askUserString();
                        System.out.println("--Введіть порядковий номер сім'ї ID");
                        int famNumber = askUserMainM(1, appController.count());
                        appController.bornChild(appController.getFamilyById(famNumber), girlname, bouname);
                        break;
                    case 2:
                        callAdroptMethod(appController);
                        break;
                    case 3:
                        break;
                }
                break;
            case 9:
                System.out.println("--Меню Видалити всіх дітей старше віку");
                appController.deleteAllChildrenOlderThen(askUserMainM(1, 200));
                break;
            default:
                System.out.println("Unknows switch");
        }


    }

    static void callAdroptMethod(FamilyController appController) {
        System.out.println("--Введіть порядковий номер сім'ї ID");
        int famN = askUserMainM(1, appController.count());
        System.out.println("--Введіть  імя");
        String name = askUserString();
        System.out.println("--Введіть  Прізвище");
        String lastname = askUserString();
        System.out.println("--Введіть  рік народження  в форматі \"dd/MM/yyyy\" ");
        String yearArg = askUserString();
        appController.adoptChild(appController.getFamilyById(famN), new Human(name, lastname, yearArg));
    }

    static void createFamily(FamilyController appController) {
        String mName;
        String mLastname;
        String birthdat;
        int miq;
        String fName;
        String fLastname;
        String fbirthdat;
        int fiq;
        System.out.println("ім'я матері");
        mName = askUserString();
        System.out.println("прізвище матері матері");
        mLastname = askUserString();
        System.out.println("Рік народженя матері \"dd/MM/yyyy\" ");
        birthdat = askUserString();
        System.out.println("Айкю матері");
        miq = askUserMainM(1, 110);

        System.out.println("ім'я батька");
        fName = askUserString();
        System.out.println("прізвище батька");
        fLastname = askUserString();
        System.out.println("Рік народженя батька \"dd/MM/yyyy\" ");
        fbirthdat = askUserString();
        System.out.println("Айкю батька");
        fiq = askUserMainM(1, 110);
        Women mother = new Women(mName, mLastname, birthdat, miq);
        Men father = new Men(fName, fLastname, fbirthdat, fiq);
        Family tempF = Family.builder().withFather(father).withMother(mother).build();
        appController.addNewFamily(tempF);
    }

    static void startFamService() {
        String menuInfo = """
                ------------------------- MENU -----------------------------------------
                - 1. Заповнити тестовими даними (автоматом створити кілька сімей та зберегти їх у базі)
                - 2. Відобразити весь список сімей (відображає список усіх сімей з індексацією, що починається з 1)
                - 3. Відобразити список сімей, де кількість людей більша за задану
                - 4. Відобразити список сімей, де кількість людей менша за задану
                - 5. Підрахувати кількість сімей
                - 6. Створити нову родину
                - 7. Видалити сім'ю за індексом сім'ї у загальному списку
                - 8. Редагувати сім'ю за індексом сім'ї у загальному списку
                - 9. Видалити всіх дітей старше віку (у всіх сім'ях видаляються діти старше зазначеного віку - вважатимемо, що вони виросли)
                   - Запитати цікавий вік
                """;
        System.out.println(menuInfo);

    }

    public static int askUserMainM(int from, int tonumber) {
        Scanner sc = new Scanner(System.in);
        Integer userInput = null;


        do {
            if (!(userInput == null)) {
                System.out.printf("\nThat's not a number in range from 1-%s.\n", tonumber);
            }
            while (!sc.hasNextInt()) {
                System.out.printf("\nThat's not a number in range from 1-%s\n", tonumber);
                sc.next();
            }
            userInput = sc.nextInt();
        } while ((!(userInput >= from) || !(userInput <= tonumber)));
        return userInput;
    }

    public static String askUserString() {
        Scanner sc = new Scanner(System.in);
        String userInput = null;


        do {

            while (!sc.hasNext()) {
                System.out.printf("\n %s   -> That's not a string", userInput);
                sc.next();
            }
            userInput = sc.nextLine();
        } while (userInput.isEmpty());
        return userInput;
    }
}
