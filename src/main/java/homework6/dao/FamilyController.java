package homework6.dao;

import homework6.family.Family;
import homework6.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyController {
    FamilyService FamilyService;

    public FamilyController(homework6.dao.FamilyService familyService) {
        FamilyService = familyService;
    }

}
