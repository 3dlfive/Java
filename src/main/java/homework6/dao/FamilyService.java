package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;
import homework6.human.Men;
import homework6.human.Women;
import homework6.pet.Pet;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {


    CollectionFamilyDao familyDB = new CollectionFamilyDao();
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
    public int countFamiliesWithMemberNumber(int famSize){
        return  familyDB.getAllFamilies().stream().map(Family::countFamily).reduce(0, (accumulator, el) -> (el >= famSize) ? accumulator + 1 : accumulator);
    };
    public void createNewFamily(Human mother, Human father){
        Family nf = Family.builder().withMother(mother).withFather(father).build();
        familyDB.saveFamily(nf);
        System.out.printf("Famaly saved,\n %s ",nf);
    };
    public ArrayList<Family> addNewFamily(Family fam){
        familyDB.saveFamily(fam);
        System.out.println("Service:fam added.");
        return familyDB.getAllFamilies();
    }
    public Family bornChild(Family family, String girlName, String menName){

        Random random = new Random();
        int randomNumber = random.nextInt(2);

        int childIq = (family.getMother().getIq()+family.getFather().getIq())/2;
        if(randomNumber==0){

            Women childGirl = new Women(girlName,family.getFather().getSurname(),childIq,family);
            family.addChild(childGirl);
            familyDB.saveFamily(family);
            System.out.println("Child born , family added.");
            return family;
        }else{
            Men childBoy = new Men(menName,family.getFather().getSurname(),childIq,family);
            family.addChild(childBoy);
            System.out.println(family);
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
public int deleteAllChildrenOlderThen(int age){
    LocalDate ln = LocalDate.now();

    // return count of delegated child
    ArrayList<Family>  flist= familyDB.getAllFamilies();
    int counter = 0;
    for(Family eF:flist){

        ArrayList<Human> childs = eF.getChildren();
        for(Human child:childs){
            LocalDate ld = LocalDate.ofEpochDay(child.getYear());
            Period period = Period.between(ld, ln);
            if(period.getYears()>=age){
                eF.deleteChild(child);
                familyDB.saveFamily(eF);
                counter++;
            }

        }

    }

    return counter;

};
    public int count(){
        return familyDB.getAllFamilies().size();
    }
   public  Family getFamilyById(int id){
       return familyDB.getAllFamilies().get(id);
   };
   public Set<Pet> getPets(int familyIndex){
       return familyDB.getAllFamilies().get(familyIndex).getPet();
   };
   public Boolean addPet(int famIndex,Pet newpet){
       Family foundFam = familyDB.getAllFamilies().get(famIndex);
       foundFam.getPet().add(newpet);
       return familyDB.saveFamily(foundFam);

   };
}