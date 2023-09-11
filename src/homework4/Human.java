package homework4;

import java.util.Arrays;

public class Human {
    String name;
    String surname;
    int year;
    int iq; // 0-100
    Pet pet ; // Object Pet
    Human mother;
    Human father;
    String[][] schedule;
    Human(){
        this("UnknownName","UnknownSurname",1991,new Pet(),null,null,new String[][] {{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"},{}});
    }
    Human(String nameArg,String surnameArg,int yearArg,Human motherArg,Human fatherArg){
        this( nameArg,surnameArg,yearArg,new Pet(),motherArg,fatherArg,new String[][] {{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"},{}});

    }
    Human(String nameArg,String surnameArg,int yearArg){
        this(nameArg,surnameArg,yearArg,new Pet(),new Human(),new Human(),new String[][] {{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"},{}});

    }
    Human(String nameArg,String surnameArg,int yearArg,Pet petArg,Human motherArg,Human fatherArg,String[][] scheduleArg){
        name=nameArg;
        surname=surnameArg;
        year=yearArg;
        pet=petArg;
        mother=motherArg;
        father=fatherArg;
        schedule=scheduleArg;
        System.out.println("New object Human was created %s\n");
    }
    void greetPet(){
        System.out.printf("Привіт, %s \n",pet);
    }
    void describePet(){
        System.out.printf("У мене є %s, їй %s років, він %s \n",pet.species,pet.age,pet.trickLevel>50?"дуже хитрий":"майже не хитрий");
    }
    public String toString(){
        String description = String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s %s, father=%s %s, pet=%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}} \n",name,surname,year,iq,mother.name,mother.surname,father.name,father.surname,pet.species,pet.nickname,pet.age,pet.trickLevel, Arrays.toString(pet.habits));
        System.out.printf(description);
        return description;
    }
}
class HumanTest{
    public static void main(String[] args) {
        Human human1 = new Human("Den","Secretovskiy",1991,new Human("Vlad","Yama",1991),new Human("Oksana","Petrova",1991));
        human1.toString();
        human1.describePet();
    }
}
