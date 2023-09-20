package homework4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    Family f1 ;
    @BeforeEach
    void setup(){
        f1 = Family.builder().withMother(new Human("Oksana","Pertovna",1991)).withFather(new Human("Oleg","Kopchik",1992))
                .build();
    }
    @AfterEach
    void cleanup(){
        f1 = null;
    }
    @Test
    @DisplayName(value = "User Family counter more than two.")
    void iscount_Family_More_than_Two() {

        int resultCounting = f1.countFamily();
        assertTrue(resultCounting>=2);
//        assertTrue(resultCounting<2);

        /* assertEquals(2,resultCounting); */
    }

    @Test
    void addChild() {
    }

    @Test
    void deleteChild() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}