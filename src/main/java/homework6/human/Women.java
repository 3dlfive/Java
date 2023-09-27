package homework6.human;

public final class Women extends Human {
    public Women(String name,String Lastname,int age){
        super(name,Lastname,age);
    }
    @Override
    public void greetPet(){
            System.out.printf("Привіт друже на імя, %s \n",super.getPet().getNickname());

    }
    public boolean makeup(boolean s){
        System.out.println(super.getName()+" вже підкрасилась.");
        return s;
    }
}
