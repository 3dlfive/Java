package homework6.pet;

public class Dog extends Pet implements startFoul {
    public Dog(String kiten, int i, int i1, String[] strings) {
        super(kiten,i,i1,strings);
        super.setSpecies(Species.DOG);
    }

    public Dog() {
        super("Unknown",1,0,new String[]{"UNKNOWN"});
        super.setSpecies(Species.DOG);
    }
    @Override
    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s . Я скучив!\n",this.getNickname());
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");

    }
}
