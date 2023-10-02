package homework6;

import homework6.pet.RoboCat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
   void testToString(){
        RoboCat pet = new RoboCat("Snejok",1,51,new String[]{"eat carrot","sleep"});
        String petToStringString = pet.toString();
        String equString = "робокіт{nickname='Snejok', age=1, trickLevel=51, habits=[[sleep, eat carrot]] \nВміє літати? false\nМає вовну? true\nКількість лап 4";
        assertEquals(equString,petToStringString);
    }
}
