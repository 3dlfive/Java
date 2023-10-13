package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;

import java.util.List;

public class FamilyService {
    CollectionFamilyDao familyDB;

    public FamilyService(FamilyDao familyDao) {
        familyDao = familyDao;
    }

    public void displayAllFamilies(){
        System.out.println(familyDB.getAllFamilies());
    }
    public void getFamiliesBiggerThan(int biggerThan) {
        List<Family> fl = familyDB.getAllFamilies();
        fl.stream().filter(el->el.countFamily()>biggerThan).forEach(System.out::println);
    };
    public void getFamiliesLessThan(int lessThan){
        List<Family> fl = familyDB.getAllFamilies();
        fl.stream().filter(el->el.countFamily()>lessThan).forEach(System.out::println);
    };
    int countFamiliesWithMemberNumber(int famSize){
        return  familyDB.getAllFamilies().stream().map(Family::countFamily).reduce(0, (accumulator, el) -> (el >= famSize) ? accumulator + 1 : accumulator);
    };
    void createNewFamily(Human mother, Human father){
        Family nf = Family.builder().withMother(mother).withFather(father).build();
        familyDB.saveFamily(nf);
        System.out.printf("Fam created and saved,\n %s ",nf);
    };
//    Family bornChild(Family family, String name, String LastName);
//    Family adoptChild(Family family,Human child);
//
//    void deleteAllChildrenOlderThen(int age);
//    int count();
//    Family getFamilyById(int id);
//    List getPets(int familyIndex);
}
