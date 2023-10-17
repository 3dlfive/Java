package homework6.dao;

import homework6.family.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyDao<F> implements FamilyDao {
    ArrayList <F> familyList = new ArrayList<>();;

    public CollectionFamilyDao(ArrayList<F> familyList) {
        this.familyList = familyList;
    }


    @Override
    public List<F> getAllFamilies() {
        return familyList.stream().toList();
    }

    @Override
    public Boolean deleteByIndex(int index) {
        int templength = familyList.size();
        familyList.remove(index);
        return templength != familyList.size();
    }

    @Override
    public Boolean deleteFamily(Object family) {
        return null;
    }

    @Override
    public Boolean saveFamily(Object family) {
        return null;
    }

    @Override
    public Optional<Family> findById(Object o) {
        return Optional.empty();
    }
}
