package homework6.human;

import homework6.family.Family;

import java.util.Random;

public final class Women extends Human  {
    public Women(String name,String Lastname,String age){
        super(name,Lastname,age);
    }
    public Women(String name, String Lastname, String age, int iq, Family f2){
         super(name,Lastname,age,iq,f2);
    }
    public Women(String name, String Lastname, String age, int iq){
         super(name,Lastname,age,iq);
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
