package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;
import homework6.human.Men;
import homework6.human.Women;
import homework6.pet.Pet;

import java.util.*;

public class FamilyService {


    CollectionFamilyDao familyDB;
    public void setFamilyDB(CollectionFamilyDao familyDB) {
        this.familyDB = familyDB;
    }
    public FamilyService(CollectionFamilyDao familyDao) {
        this.familyDB = familyDao;
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
    public Family bornChild(Family family, String girlName, String menName){

        Random random = new Random();
        int randomNumber = random.nextInt(2);

        int childIq = (family.getMother().getIq()+family.getFather().getIq())/2;
        if(randomNumber==0){

            Women childGirl = new Women(girlName,family.getFather().getSurname(),"20/03/2016",childIq,family);
            family.addChild(childGirl);
            familyDB.saveFamily(family);
            System.out.println("Child born , family added.");
            return family;
        }else{
            Men childBoy = new Men(menName,family.getFather().getSurname(),"20/03/2016",childIq,family);
            family.addChild(childBoy);
            familyDB.saveFamily(family);
            System.out.println("Child born , family added.");
            return family;
        }
    }
    public Family adoptChild(Family family,Human child){
        family.addChild(child);
        System.out.println("Child adopted.");
        familyDB.saveFamily(family);
return  family;

    };
//
public void deleteAllChildrenOlderThen(int age){
    List<Family>  flist= familyDB.getAllFamilies();
    ArrayList<Family> filtered = (ArrayList<Family>) flist.stream().filter(el-> el.getChildren().stream().filter(child->child.getYear()>=age).isParallel()).toList();
    this.familyDB = new CollectionFamilyDao(filtered);

};
    public int count(){
        return familyDB.getAllFamilies().size();
    }
   public Optional<Family> getById(int id){
       Optional<Family> family = (Optional<Family>) familyDB.getAllFamilies().get(id);
       return family;
   };
   public ArrayList getPets(int familyIndex){
       Family f1 = (Family) familyDB.getAllFamilies().get(familyIndex);
       Set<Pet> pl = f1.getPet();
       return (ArrayList) pl;
   };
   public Optional<Family> addPet(int famIndex, Pet newpet){
       Optional<Family> foundFam = this.getById(famIndex);
       familyDB.saveFamily(foundFam);
       return foundFam;

   };
}
