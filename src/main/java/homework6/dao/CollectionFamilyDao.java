package homework6.dao;

import homework6.family.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    ArrayList <Family> familyList = new ArrayList<>();;

    public CollectionFamilyDao(ArrayList<Family> familyList) {
        this.familyList = familyList;
    }    public CollectionFamilyDao() {
        this.familyList = new ArrayList<>();
    }

    @Override
    public ArrayList<Family> getAllFamilies() {
        return this.familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return this.getFamilyList().get(index);
    }

    @Override
    public Boolean deleteFamilyByIndex(int index) {
        int before = this.familyList.size();
        this.familyList.remove(index);
        return before != this.familyList.size();
    }

    @Override
    public Boolean deleteFamily(Family family) {
        return this.familyList.remove(family);
    }

    @Override
    public Boolean saveFamily(Family family) {
        if (familyList.contains(family)){
            List <Family> newList = familyList.stream().map(el->el.equals(family)?family:el).toList();
            return true;
        } else {
            return this.familyList.add(family);
        }
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(ArrayList<Family> familyList) {
        this.familyList = familyList;
    }
}
