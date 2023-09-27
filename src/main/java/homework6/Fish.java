package homework6;

public class Fish extends Pet{
    public Fish( String kiten, int i, int i1, String[] strings) {
        super(kiten,i,i1,strings);
        super.setSpecies(Species.FISH);
    }
    @Override
    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s . Я скучив!\n",this.getNickname());
    }
}
