package homework4;

import java.util.Arrays;

public class Human {
    String name;
    String surname;
    int year;
    int iq; // 0-100
    Pet pet ; // Object Pet
    Human mother = new Human();
    Human father = new Human();
    String[][] schedule;
    void greetPet(){
        System.out.printf("Привіт, %s \n",pet);
    }
    void describePet(){
        System.out.printf("У мене є %s, їй %s років, він %s \n",pet.species,pet.age,pet.trickLevel>50?"дуже хитрий":"майже не хитрий");
    }
    public String toString(){
        String description = String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s %s, father=%s %s, pet=%s{nickname='%s', age=%d, trickLevel=%d, habits=[%s]}} \n",name,surname,year,iq,mother.name,mother.surname,father.name,father.surname,pet.species,pet.nickname,pet.age,pet.trickLevel, Arrays.toString(pet.habits));
        System.out.printf(description);
        return description;
    }
}
class HumanTest{
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.name="Denys";
        human1.surname="Try";

        human1.describePet();
    }
}
