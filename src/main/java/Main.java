import homework6.dao.CollectionFamilyDao;
import homework6.dao.FamilyController;
import homework6.dao.FamilyService;
import homework6.family.Family;
import homework6.human.Human;
import homework6.human.Men;
import homework6.human.Women;
import homework6.pet.Dog;
import homework6.pet.DomesticCat;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Family f1 = Family.builder().withMother(new Human("Oksana","Pertovna","10/08/1992")).withFather(new Human("Oleg","Kopchik","10/08/1994"))
                .build();

        Family f2 = Family.builder().withMother(new Human("Yana","Hujen","10/08/1994")).withFather(new Human("Den","Topik","10/08/1999")).withChildren(new Human[]{new Human("Diana","Dovbik","10/08/2014")})
                .build();

        Family f3 = Family.builder().withMother(new Human("Yana","Hujen","10/02/1992")).withFather(new Human("Den","Topik","10/08/1992")).withChildren(new Human[]{new Human("Diana","Petrik","10/08/2014")}).withPet(new Dog("Kiten",6,12,new String[]{"bark","walk"}))
                .build();


        Women mother = new Women("Olesa","Krepkiy");
        Men father = new Men("Olegka","Krepkiy","12/12/1991");
        Human child01 = new Human("Olegka","Krepkiy","12/12/1991");
        DomesticCat pet = new DomesticCat("Snejok",1,51,new String[]{"eat carrot","sleep"});
        Family f4 = Family.builder().withMother(mother).withFather(father).withPet(pet).build();
        ArrayList<Family> fl = new ArrayList<>();
        fl.add(f1);
        fl.add(f2);


        FamilyController rodDom325 = new FamilyController(new FamilyService(new CollectionFamilyDao(fl)));
        rodDom325.createNewFamily(mother,father);

        rodDom325.addNewFamily(f3);
        rodDom325.addNewFamily(f4);
        System.out.println("AllFam----");
        rodDom325.displayAllFamilies();
        System.out.println("getFamiliesBiggerThan----");
        rodDom325.getFamiliesBiggerThan(2);
        System.out.println("getFamiliesLessThan----");
        rodDom325.getFamiliesLessThan(3);
        System.out.println("countFamiliesWithMemberNumber----");
        rodDom325.countFamiliesWithMemberNumber(3);
        System.out.println("bornChild----");
        rodDom325.bornChild(f1,"Anna","Gerakl");
        rodDom325.bornChild(f1,"Olya","Jeck");
        System.out.println(rodDom325.getFamilyById(1).getChildren());
        System.out.println("adoptChild----");
        rodDom325.adoptChild(f1,child01);

       System.out.println(rodDom325.adoptChild(f1,child01));
        System.out.println("deleteAllChildrenOlderThen --->");
//        rodDom325.deleteAllChildrenOlderThen(13);
        System.out.println(rodDom325.getFamilyById(0));
        rodDom325.deleteAllChildrenOlderThen(30);
        System.out.println(rodDom325.getFamilyById(0));
        System.out.println("count() --->");

        System.out.println(rodDom325.count());
        System.out.println(rodDom325.addPet(1,pet));
        System.out.println(rodDom325.getPets(1));
    }
}
