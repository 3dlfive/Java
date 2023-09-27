import homework6.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Family f1 = Family.builder().withMother(new Human("Oksana","Pertovna",1991)).withFather(new Human("Oleg","Kopchik",1992))
                .build();
        System.out.println(f1.getMother());
        System.out.println(f1.getFather());
        System.out.println(Arrays.toString(f1.getChildren()));
        System.out.println(f1.getPet());
        Family f2 = Family.builder().withMother(new Human("Yana","Hujen",1992)).withFather(new Human("Den","Topik",1992)).withChildren(new Human[]{new Human("Diana","Dovbik",2012)})
                .build();
        System.out.println(f2.getMother());
        System.out.println(f2.getFather());
        System.out.println(Arrays.toString(f2.getChildren()));
        System.out.println(f2.getPet());
        Family f3 = Family.builder().withMother(new Human("Yana","Hujen",1992)).withFather(new Human("Den","Topik",1992)).withChildren(new Human[]{new Human("Diana","Dovbik",2012)}).withPet(new Dog("Kiten",6,12,new String[]{"bark","walk"}))
                .build();
        System.out.println("Mother ===="+ f3.getMother());
        System.out.println("Father ===="+ f3.getFather());
        System.out.println("Children ===="+ Arrays.toString(f3.getChildren()));
        System.out.println("Pet ===="+f3.getPet());


        Human mother = new Human("Olesa","Krepkiy",1921);
        Human father = new Human("Olegka","Krepkiy",1990);
        Human childen = new Human("Alex","Krepkiy",2012);
        DomesticCat pet = new DomesticCat("Snejok",1,51,new String[]{"eat carrot","sleep"});
        Family f4 = Family.builder().withMother(mother).withFather(father).withChildren(new Human[]{childen}).withPet(pet).build();
        System.out.println("Family N4 =="+f4.toString());
        mother.setFamily(f4);
        father.setFamily(f4);
        childen.setFamily(f4);
        mother.setPet(pet);
        father.setPet(pet);
        childen.setPet(pet);
        System.out.println("Family N4 with links =="+f4.toString());
        System.out.println("Всі доступні методи у дитини");
        System.out.println(childen.toString());
        System.out.println(childen.getName());
        System.out.println(childen.getSurname());
        System.out.println(childen.getIq());
        System.out.println(childen.getPet());
        System.out.println(childen.getFamily());
        childen.describePet();
        childen.greetPet();
        childen.getScheduleNormolized();
        pet.respond();
        pet.eat();
        pet.foul();
        f4.deleteChild(new Human("Alex","Krepkiy",2012));
        /*
        Loop that full memory and fire method finalize();
        int counter = 0;
        do {
            System.out.println(counter);
            new Human("Den","Secretovskiy",1991, Family.builder().withFather(new Human("Anto","Kirov",1992)).withMother(new Human("Oksana","Danivna",2001)).build());
            counter++;
        } while (!(counter ==10000000)); */

    }
}
