package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;
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

    public void displayAllFamilies() {
        service.displayAllFamilies();
    }
    public void getFamiliesBiggerThan(int biggerThan) {
        service.getFamiliesBiggerThan(biggerThan);
    }
    public void getFamiliesLessThan(int lessThan){
        service.getFamiliesLessThan(lessThan);
    };
    public int countFamiliesWithMemberNumber(int famSize){
      return service.countFamiliesWithMemberNumber(famSize);
    };

    public void createNewFamily(Human mother, Human father){
        service.createNewFamily(mother,father);
    };
    public Family bornChild(Family family, String girlName, String menName){
        return service.bornChild(family,girlName,menName);
    }
    public Family adoptChild(Family family,Human child){
        return service.adoptChild(family,child);
    }
    public CollectionFamilyDao deleteAllChildrenOlderThen(int age){
        return service.deleteAllChildrenOlderThen(age);
    }
    public int count(){
        return service.count();
    }
    public  Family getFamilyById(int id){
        return service.getFamilyById(id);
    };
    public Set<Pet> getPets(int familyIndex){
        return service.getPets(familyIndex);
    }
    public Boolean addPet(int famIndex, Pet newpet){
        return service.addPet(famIndex,newpet);
    }
    public ArrayList<Family> addNewFamily(Family f){
        return  service.addNewFamily(f);
    }
}
