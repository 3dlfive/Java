package homework4;


import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel; //0-100
    private String[] habits;
    Pet(String species2,String nickname2){
        this(species2,nickname2,0,0,new String[]{"play on street","sleep a lot"});
    }
    Pet(){
        this("cat","Dryzhok",1,40,new String[]{"murchatb","catch mouses"});
    }
    Pet(String species,String nickname,int age2,int trickLevel2,String[] habbits2){
        this.setSpecies(species);
        this.setNickname(nickname);
        this.setAge(age2);
        this.setTrickLevel(trickLevel2);
        this.setHabits(habbits2);

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

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

}
class PetTest {
    public static void main(String[] args) {
        Pet sharik = new Pet("dog","Sharick",5,45, new String[]{"eat","sleep"});
        sharik.toString();

    }

}