package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FamilyDao<T, ID> {
    List<T> getAllFamilies();

    Boolean deleteByIndex(int index);
    Boolean deleteFamily(T family);
    Boolean saveFamily(T family);

    Optional<T> findById(ID id);


}
