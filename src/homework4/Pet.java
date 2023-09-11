package homework4;

import org.w3c.dom.ls.LSOutput;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel; //0-100
    String[] habits;
    void eat(){
        System.out.println("Я ї'м!");
    }
    void respond(){
        System.out.printf("Привіт, хазяїн. Я - %s . Я скучив!\n",nickname);
    }
    void foul(){
        System.out.println("Потрібно добре замести сліди...");
    }
}
class PetTest {
    public static void main(String[] args) {
        Pet sharik = new Pet();
        sharik.nickname = "Sharik";
        sharik.respond();
    }

}