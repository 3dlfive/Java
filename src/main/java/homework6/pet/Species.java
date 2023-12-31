package homework6.pet;

public enum Species {
    DOG("пес",false,4,true),
    UNKNOWN("Невідомий",false,2,false),
    CAT("кіт",false,4,true),
    FISH("рибка",false,0,false),
    BIRD("птах",true,2,false),
    ROBOCAT("робокіт",false,4,true),
    DOMESTICCAT("домашній кіт",false,4,true),
    RACOON("энот",false,4,true);
    private String translation;
    private boolean canFly;
    private boolean hasFur;
    private int numberOfLegs;



    Species(String translation, boolean canFlyA, int numberOfLegsA, boolean hasFurA){
        this.translation=translation;
        this.canFly = canFlyA;
        this.numberOfLegs = numberOfLegsA;
        this.hasFur = hasFurA;
    }

    public String getTranslation() {
        return translation;
    }
    public boolean isCanFly() {
        return canFly;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }
};