package homework4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
   void testToString(){
        Pet pet = new RoboCat(Species.CAT,"Snejok",1,51,new String[]{"eat carrot","sleep"});
        String petToStringString = pet.toString();
        String equString = "кіт{nickname='Snejok', age=1, trickLevel=51, habits=[[eat carrot, sleep]] \nВміє літати? false\nМає вовну? true\nКількість лап 4";
        assertEquals(equString,petToStringString);
    }
}
