package homework6.dao;

import homework6.family.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    ArrayList <Family> familyList = new ArrayList<>();;

    @Override
    public List<Family> getAllFamilies() {
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
        return this.familyList.add(family);
    }

    public List<Family> getFamilyList() {
        return familyList;
    }
}
