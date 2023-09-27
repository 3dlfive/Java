package homework6.human;

public final class Men extends Human {
    @Override
    public void greetPet(){
        System.out.printf("Привіт друже типу, %s \n",super.getPet().getSpecies());
    }
    public boolean repairCar(boolean a){
        System.out.println(super.getName()+" " + super.getSurname() + " fix a car.");
        return a;
    }
}
