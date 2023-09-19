package homework4;

public enum Species {
    DOG("пес"),CAT("кіт"),FISH("рибка"),BIRD("птах"),RACOON("энот");
    private String translation;

    Species(String translation){
        this.translation=translation;
    }

    public String getTranslation() {
        return translation;
    }
};