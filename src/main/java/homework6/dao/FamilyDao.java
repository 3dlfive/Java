package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;

import java.util.ArrayList;
import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    Boolean deleteFamilyByIndex(int index);

    Boolean deleteFamily(Family family);

    Boolean saveFamily(Family family);

    List<Family> loadData();

}
