package homework4;

import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq; // 0-100
    private Pet pet ; // Object Pet
    private Family family;



    private String[][] schedule ;
    Human(){
        this("UnknownName","UnknownSurname",1991,new Pet(),null,new String[][] {{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"},{"t1","t2","t3","t4","t5","t5","t5"}});
    }
    Human(String nameArg,String surnameArg,int yearArg,Family family){
        this( nameArg,surnameArg,yearArg,new Pet(), family,new String[][] {{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"},{"t1","t2","t3","t4","t5","t5","t5"}});

    }
    Human(String nameArg,String surnameArg,int yearArg){
        this(nameArg,surnameArg,yearArg,new Pet(),null, new String[][] {{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"},{"t1","t2","t3","t4","t5","t5","t5"}});

    }

    Human(String nameArg,String surnameArg,int yearArg,Pet petArg,Family family,String[][] scheduleArg){
        this.setName(nameArg);
        this.setSurname(surnameArg);
        this.setYear(yearArg);
        this.setPet(petArg);
        this.setFamily(family);
        this.setSchedule(scheduleArg);
    }
    void greetPet(){
        System.out.printf("Привіт, %s \n",pet.getNickname());
    }
    void describePet(){
        System.out.printf("У мене є %s, їй %s років, він %s \n",pet.getSpecies(),pet.getAge(),pet.getTrickLevel()>50?"дуже хитрий":"майже не хитрий");
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
        if ((iq>0 && iq<100)){
            this.iq = iq;
        } else{
            throw new IllegalStateException("We expect iq in range 0-100. ");
        }

    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setFamily(Family f){
        this.family=f;
    }
    public  Family getFamily(){
     return family;
    }



    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;

    }
    public String[] getScheduleNormolized() {
        String[] normalizedArray = new String[schedule[0].length];

        for (int cell=0;cell<normalizedArray.length;cell++){
            normalizedArray[cell]="["+schedule[0][cell]+","+schedule[1][cell]+"]";
        }

        return normalizedArray;
        }
    public String[][] getSchedule() {
     return schedule;
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.toString(getScheduleNormolized()) +
                '}';
    }
}



    class HumanTest{
    public static void main(String[] args) {
        Human human1 = new Human("Den","Secretovskiy",1991, Family.builder().withFather(new Human("Anto","Kirov",1992)).withMother(new Human("Oksana","Danivna",2001)).build());
        System.out.println(human1.toString());

        human1.greetPet();
        human1.describePet();
    }
}
