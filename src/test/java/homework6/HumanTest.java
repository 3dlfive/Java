package homework6;

import homework6.human.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    @Test
    void toStringTest() {
        Human t1 = new Human("Yana","Hujen",1992);
        System.out.println(t1);
       String result = "Human{name='Yana', surname='Hujen', year=1992, iq=1, schedule={MONDAY=No entry., SUNDAY=No entry., FRIDAY=No entry., TUESDAY=No entry., WEDNESDAY=No entry., THURSDAY=No entry., SATURDAY=No entry.}}"
               ;
        assertEquals(t1.toString(),result);
    }


}