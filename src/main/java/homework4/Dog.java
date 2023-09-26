package homework4;

public class Dog extends Pet{
    public Dog(Species species, String kiten, int i, int i1, String[] strings) {
        super(species,kiten,i,i1,strings);
    }

    public Dog() {
        super(Species.DOG,"Unknown",1,0,null);
    }
}
