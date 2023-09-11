package homework4;

public class Human {
    String name;
    String surname;
    int year;
    int iq; // 0-100
    Pet pet; // Object Pet
    Human mother;
    Human father;
    String[][] schedule;
    void greetPet(){
        System.out.printf("Привіт, %s \n",pet);
    }
    void describePet(){
        System.out.printf("У мене є %s, їй %s років, він %s",pet.species,pet.age,pet.trickLevel>50?"дуже хитрий":"майже не хитрий");
    }
}
