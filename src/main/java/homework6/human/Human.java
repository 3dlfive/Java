package homework6.human;

import homework6.family.Family;
import homework6.pet.Dog;
import homework6.pet.Pet;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq; // 0-100
    private Pet pet ; // Object Pet
    private Family family;
//    static {
//        System.out.println("New class Human loaded");
//        }
//    {
//        System.out.println("New Human object created.");
//    }

    private String[][] schedule ;
    Human(){
        this("UnknownName","UnknownSurname",1991,0,new Dog(),null,new String[][] {{DayOfWeek.SUNDAY.name(),DayOfWeek.MONDAY.name(),DayOfWeek.THURSDAY.name(),DayOfWeek.WEDNESDAY.name(),DayOfWeek.TUESDAY.name(),DayOfWeek.FRIDAY.name(),DayOfWeek.SATURDAY.name()},{"t1","t2","t3","t4","t5","t5","t5"}});
    }
    public Human(String nameArg, String surnameArg, int yearArg,  Family family){
        this( nameArg,surnameArg,yearArg,1,new Dog(), family,new String[][] {{DayOfWeek.SUNDAY.name(),DayOfWeek.MONDAY.name(),DayOfWeek.THURSDAY.name(),DayOfWeek.WEDNESDAY.name(),DayOfWeek.TUESDAY.name(),DayOfWeek.FRIDAY.name(),DayOfWeek.SATURDAY.name()},{"t1","t2","t3","t4","t5","t5","t5"}});

    }
    public Human(String nameArg, String surnameArg, int yearArg,int iqA, Family family){
        this( nameArg,surnameArg,yearArg,iqA,new Dog(), family,new String[][] {{DayOfWeek.SUNDAY.name(),DayOfWeek.MONDAY.name(),DayOfWeek.THURSDAY.name(),DayOfWeek.WEDNESDAY.name(),DayOfWeek.TUESDAY.name(),DayOfWeek.FRIDAY.name(),DayOfWeek.SATURDAY.name()},{"t1","t2","t3","t4","t5","t5","t5"}});

    }
    public Human(String nameArg, String surnameArg, int yearArg){
        this(nameArg,surnameArg,yearArg,1,new Dog(),null, new String[][] {{DayOfWeek.SUNDAY.name(),DayOfWeek.MONDAY.name(),DayOfWeek.THURSDAY.name(),DayOfWeek.WEDNESDAY.name(),DayOfWeek.TUESDAY.name(),DayOfWeek.FRIDAY.name(),DayOfWeek.SATURDAY.name()},{"t1","t2","t3","t4","t5","t5","t5"}});

    }    public Human(String nameArg, String surnameArg, int yearArg,int iqA){
        this(nameArg,surnameArg,yearArg,iqA,new Dog(),null, new String[][] {{DayOfWeek.SUNDAY.name(),DayOfWeek.MONDAY.name(),DayOfWeek.THURSDAY.name(),DayOfWeek.WEDNESDAY.name(),DayOfWeek.TUESDAY.name(),DayOfWeek.FRIDAY.name(),DayOfWeek.SATURDAY.name()},{"t1","t2","t3","t4","t5","t5","t5"}});

    }

    Human(String nameArg, String surnameArg, int yearArg, int iqArg,Pet petArg, Family family, String[][] scheduleArg){
        this.setName(nameArg);
        this.setSurname(surnameArg);
        this.setYear(yearArg);
        this.setIq(iqArg);
        this.setPet(petArg);
        this.setFamily(family);
        this.setSchedule(scheduleArg);
    }
    public void greetPet(){
        System.out.printf("Привіт, %s \n",pet.getNickname());
    }
    public void describePet(){
        System.out.printf("У мене є %s, їй %s років, він %s \n",pet.getSpecies().getTranslation(),pet.getAge(),pet.getTrickLevel()>50?"дуже хитрий":"майже не хитрий");
    }
    public boolean feedPet(boolean bool){
        int r = (int)(Math.random()*100);
        int petT = this.pet.getTrickLevel();
        if (bool){
            System.out.println("Pet is feeded.");
            return true;
        }else{
            if ( petT!=r){
                System.out.printf("Думаю, %s не голодний.\n",this.pet.getNickname());
                return false;
            } else {
                System.out.printf("Хм... годувати %s \n",this.pet.getNickname());
                return true;

            }
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return getYear() == human.getYear() && Objects.equals(getName(), human.getName()) && Objects.equals(getSurname(), human.getSurname());
    }
    @Override
    public void finalize(){
        System.out.println("Обєкт прибраний" +this.toString());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getYear());
    }
}

