package homework6.human;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WomenTest {
    Women women1;



    @Test
    @DisplayName("Test makeup method")
    public void makeup() {
        women1 = new Women("Anna","Petrivna",2012);
        boolean result = women1.makeup(true);
        assertTrue(result);
    }
}