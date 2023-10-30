package homework6.dao;

import homework6.family.Family;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    ArrayList<Family> familyList = new ArrayList<>();


    public CollectionFamilyDao(ArrayList<Family> familyList) {
        this.familyList = familyList;
    }

    public CollectionFamilyDao() {
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
        if (familyList.contains(family)) {
            
            List<Family> newList = familyList.stream().map(el -> el.equals(family) ? family : el).toList();

            saveToFile(newList);


            return true;
        } else {
            System.out.println("Not conta");
            boolean adedfam = this.familyList.add(family);
            saveToFile(familyList);
            return adedfam;
        }
    }

    public void saveToFile(List<Family> newList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("db.bin")
        )) {

            outputStream.writeObject(newList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //    public Boolean saveFamily(Family family) {
//        if (familyList.contains(family)) {
//            List<Family> newList = familyList.stream().map(el -> el.equals(family) ? family : el).toList();
//            return true;
//        } else {
//            return this.familyList.add(family);
//        }
//    }


    @Override
    public List<Family> loadData() {
        System.out.println("Load data");

        List<Family> famListLoaded = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("db.bin")
        )) {
            famListLoaded = (List<Family>) inputStream.readObject();

            System.out.println(famListLoaded);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (famListLoaded != null) {

            this.familyList.addAll(famListLoaded);
        }
        System.out.println(famListLoaded);
        return famListLoaded;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }


}
