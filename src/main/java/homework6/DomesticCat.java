package homework6;

public class DomesticCat extends  Pet implements startFoul{
    public DomesticCat(String kiten, int i, int i1, String[] strings) {
        super(kiten,i,i1,strings);
        super.setSpecies(Species.DOMESTICCAT);
    }
    public DomesticCat() {
        super("Unknown",1,0,null);
        super.setSpecies(Species.DOMESTICCAT);
    }
    @Override
    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s . Я скучив!\n",this.getNickname());
    }
    @Override
    public void foul(){
        System.out.println("Потрібно добре замести сліди...");
}
}
