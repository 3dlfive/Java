package homework4;

import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq; // 0-100
    private Pet pet ; // Object Pet
    private Human mother;
    private Human father;
    private String[][] schedule;
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
        this.setName(nameArg);
        this.setSurname(surnameArg);
        this.setYear(yearArg);
        this.setPet(petArg);
        this.setMother(motherArg);
        this.setFather(fatherArg);
        this.setSchedule(scheduleArg);
    }
    void greetPet(){
        System.out.printf("Привіт, %s \n",pet.getNickname());
    }
    void describePet(){
        System.out.printf("У мене є %s, їй %s років, він %s \n",pet.getSpecies(),pet.getAge(),pet.getTrickLevel()>50?"дуже хитрий":"майже не хитрий");
    }
    @Override
    public String toString(){
        String description = String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s %s, father=%s %s, pet=%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}} \n",getName(),getSurname(),getYear(),getIq(),getMother().getName(),getMother().getSurname(),getFather().getName(),getFather().getSurname(),pet.getSpecies(),pet.getNickname(),pet.getAge(),pet.getTrickLevel(), Arrays.toString(pet.getHabits()));
        System.out.printf(description);
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
}
class HumanTest{
    public static void main(String[] args) {
        Human human1 = new Human("Den","Secretovskiy",1991,new Human("Vlad","Yama",1991),new Human("Oksana","Petrova",1991));
        human1.toString();
        human1.greetPet();
        human1.describePet();
    }
}
