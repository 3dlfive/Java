package homework6.dao;

import homework6.FamilyException.FamilyOverflowException;
import homework6.family.Family;
import homework6.human.Human;
import homework6.human.Men;
import homework6.human.Women;
import homework6.pet.Dog;
import homework6.pet.DomesticCat;
import homework6.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class FamilyController {
    FamilyService service;

    public FamilyController(FamilyService familyService) {
        service = familyService;
    }

    public void generateFam() {
        Family f1 = Family.builder().withMother(new Human("Oksana", "Pertovna", "10/08/1992")).withFather(new Human("Oleg", "Kopchik", "10/08/1994"))
                .build();

        Family f2 = Family.builder().withMother(new Human("Yana", "Hujen", "10/08/1994")).withFather(new Human("Den", "Topik", "10/08/1999")).withChildren(new Human[]{new Human("Diana", "Dovbik", "10/08/2014")})
                .build();

        Family f3 = Family.builder().withMother(new Human("Yana", "Hujen", "10/02/1992")).withFather(new Human("Den", "Topik", "10/08/1992")).withChildren(new Human[]{new Human("Diana", "Petrik", "10/08/2014")}).withPet(new Dog("Kiten", 6, 12, new String[]{"bark", "walk"}))
                .build();
        Women mother = new Women("Olesa", "Krepkiy");
        Men father = new Men("Olegka", "Krepkiy", "12/12/1991");
        Human child01 = new Men("Olegka", "Krepkiy", "12/12/1991");
        DomesticCat pet = new DomesticCat("Snejok", 1, 51, new String[]{"eat carrot", "sleep"});
        Family f4 = Family.builder().withMother(mother).withFather(father).withPet(pet).build();
        this.addNewFamily(f1);
        this.addNewFamily(f2);
        this.addNewFamily(f3);
        this.addNewFamily(f4);

    }

    public void displayAllFamilies() {
        service.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int biggerThan) {
        service.getFamiliesBiggerThan(biggerThan);
    }

    public void getFamiliesLessThan(int lessThan) {
        service.getFamiliesLessThan(lessThan);
    }

    ;

    public void loadfromFile() {
        service.loadD();
    }

    public int countFamiliesWithMemberNumber(int famSize) {
        return service.countFamiliesWithMemberNumber(famSize);
    }

    ;

    public void createNewFamily(Human mother, Human father) {
        service.createNewFamily(mother, father);
    }

    ;

    public Family bornChild(Family family, String girlName, String menName) throws FamilyOverflowException {
        int famsize = family.countFamily();
        if (famsize >= 5) throw new FamilyOverflowException("Розмір родини більше або дорівнює 5", famsize);

        return service.bornChild(family, girlName, menName);
    }

    public Family adoptChild(Family family, Human child) throws FamilyOverflowException {
        int famsize = family.countFamily();
        if (famsize >= 5) throw new FamilyOverflowException("Розмір родини більше або дорівнює 5", famsize);
        return service.adoptChild(family, child);
    }

    public CollectionFamilyDao deleteAllChildrenOlderThen(int age) {
        return service.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return service.count();
    }

    public Family getFamilyById(int id) {
        return service.getFamilyById(id);
    }

    ;

    public boolean deleteByIndex(int index) {
        return service.removeFamily(index);
    }

    public Set<Pet> getPets(int familyIndex) {
        return service.getPets(familyIndex);
    }

    public Boolean addPet(int famIndex, Pet newpet) {
        return service.addPet(famIndex, newpet);
    }

    public ArrayList<Family> addNewFamily(Family f) {
        return service.addNewFamily(f);
    }
}
