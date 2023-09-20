package homework4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    Family f1 = Family.builder().withMother(new Human("Oksana","Pertovna",1991)).withFather(new Human("Oleg","Kopchik",1992))
            .build();
    @Test
    void countFamily() {

        int resultCounting = f1.countFamily();
        assertEquals(2,resultCounting);
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