package homework6;

public class RoboCat extends Pet implements startFoul{
    public RoboCat(String snejok, int i, int i1, String[] strings) {
        super(snejok,i,i1,strings);
        super.setSpecies(Species.ROBOCAT);
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
