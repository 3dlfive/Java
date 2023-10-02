package homework6;

import homework6.human.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    @Test
    void toStringTest() {
        Human t1 = new Human("Yana","Hujen",1992);
        System.out.println(t1);
       String result = "Human{name='Yana', surname='Hujen', year=1992, iq=1, schedule={}}"
;
        assertEquals(t1.toString(),result);
    }


}