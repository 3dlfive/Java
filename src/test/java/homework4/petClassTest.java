package homework4;

import homework4.Pet;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class petClassTest {
    @Test
    @DisplayName("Dog Names")
    void getPetName() {
        Pet pet1 = new Pet(Species.DOG,"Sharick",5,45, new String[]{"eat","sleep"});
        String petName=pet1.getNickname();
        assertEquals("Sharick",petName);
    }
//new Pet("dog","Sharick",5,45, new String[]{"eat","sleep"});
    @ParameterizedTest(name="{0} = {1}")
    @CsvSource({
            "Kyrsten,Kyrsten",
            "Dodik,Dodik",
            "Mem,Mem",
            "Fifi,Fifi"
    })
    void getPetName2(String name,String expectedResult) {
        Pet pet1 = new Pet(Species.DOG,name,5,45, new String[]{"eat","sleep"});
        String petName=pet1.getNickname();
        assertEquals(petName,expectedResult);
    }
//    @CsvSource({
//            "0,    1,   1",
//            "1,    2,   3",
//            "49,  51, 100",
//            "1,  100, 101"
//    })
//    void add(int first, int second, int expectedResult) {
//        Calculator calculator = new Calculator();
//        assertEquals(expectedResult, calculator.add(first, second),
//                () -> first + " + " + second + " should equal " + expectedResult);
//    }
}