package homework6.human;

import homework6.family.Family;

public final class Men extends Human {
    public Men(String name,String Lastname,String age){
        super(name,Lastname,age);
    }
    public Men(String name, String Lastname, String age, int iq, Family f2){
        super(name,Lastname,age,iq,f2);
    }
    public Men(String name, String Lastname,  int iq, Family f2){
        super(name,Lastname,iq,f2);
    }
    public Men(String name, String Lastname){
        super(name,Lastname);
    }
    @Override
    public void greetPet(){
        System.out.printf("Привіт друже типу, %s \n",super.getPet().getSpecies());
    }
    public boolean repairCar(boolean a){
        System.out.println(super.getName()+" " + super.getSurname() + " fix a car.");
        return a;
    }
}
