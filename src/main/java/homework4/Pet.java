package homework4;


import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private String nickname;
    private Species species;
    private int age;
    private int trickLevel; //0-100
    private String[] habits;
//    static {
//        System.out.println("New Pet Family loaded");
//    }
//    {
//        System.out.println("New Pet object created.");
//    }
    Pet(Species species2,String nickname2){
        this(species2,nickname2,0,0,new String[]{"play on street","sleep a lot"});
    }
    Pet(){
        this(Species.DOG,"unknownName",0,1,new String[]{});
    }
    public Pet(Species species, String nickname, int age2, int trickLevel2, String[] habbits2){
        this.setSpecies(species);
        this.setNickname(nickname);
        this.setAge(age2);
        this.setTrickLevel(trickLevel2);
        this.setHabits(habbits2);

    }
    public void eat(){
        System.out.println("Я ї'м!");
    }
    public void respond(){
        System.out.printf("Привіт, хазяїн. Я - %s . Я скучив!\n",nickname);
    }
    public void foul(){
        System.out.println("Потрібно добре замести сліди...");
    }
    @Override
    public String toString(){
        String myReturnString = String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=[%s] \nВміє літати? %s\nМає вовну? %s\nКількість лап %s",species.getTranslation(),nickname,age,trickLevel, Arrays.toString(habits),species.isCanFly(),species.isHasFur(),species.getNumberOfLegs());
        System.out.println(myReturnString);
        return myReturnString;
    }
    @Override
    public void finalize(){
        System.out.println("Обєкт прибраний" +this.toString());
    }
    public void setSpecies(Species species) {
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
        if (trickLevel>=0&&trickLevel<=100){
            this.trickLevel = trickLevel;

        } else {
            throw new IllegalStateException("Exspect trciklevel in range from 1 to 100.");
        }
    }

    public Species getSpecies() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age);
    }
}
