package homework4;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel; //0-100
    String[] habits;
    Pet(String species2,String nickname2){
        this(species2,nickname2,0,0,new String[]{"play on street","sleep a lot"});
    }
    Pet(){
        this("cat","Dryzhok",1,40,new String[]{"murchatb","catch mouses"});
    }
    Pet(String species1,String nickname1,int age2,int trickLevel2,String[] habbits2){
        species=species1;
        nickname=nickname1;
        age=age2;
        trickLevel=trickLevel2;
        habits=habbits2;
    }
    void eat(){
        System.out.println("Я ї'м!");
    }
    void respond(){
        System.out.printf("Привіт, хазяїн. Я - %s . Я скучив!\n",nickname);
    }
    void foul(){
        System.out.println("Потрібно добре замести сліди...");
    }
    public String toString(){
        String myReturnString = String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=[%s]",species,nickname,age,trickLevel, Arrays.toString(habits));
        System.out.println(myReturnString);
        return myReturnString;
    }
}
class PetTest {
    public static void main(String[] args) {
        Pet sharik = new Pet("dog","Sharick",5,45, new String[]{"eat","sleep"});
        sharik.toString();

    }

}