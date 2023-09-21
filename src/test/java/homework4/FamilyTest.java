package homework4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    Family f1 ;
    Family f3 ;
    Human newChild;
    Human newChild2;
    @BeforeEach
    void setup(){
        f1 = Family.builder().withMother(new Human("Oksana","Pertovna",1991)).withFather(new Human("Oleg","Kopchik",1992))
                .build();
        f3 = Family.builder().withMother(new Human("Yana","Hujen",1992)).withFather(new Human("Den","Topik",1992)).withChildren(new Human[]{new Human("Diana","Dovbik",2012)}).withPet(new Pet(Species.RACOON,"Kiten",6,12,new String[]{"bark","walk"}))
                .build();
        newChild = new Human("Alex","Deev",1992,f3);
        newChild2 = new Human("Katerina","Bugrova",1992,f3);
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
    @DisplayName("Add one child to Family.")
    void addChildArrayIncreaseItSizeByOne() {
        int sizeBefore = f3.getChildren().length;
        f3.addChild(new Human("Kenny","Amaya",2016,f3));
        int sizeAfterAdding = f3.getChildren().length;
        assertEquals(sizeBefore + 1, sizeAfterAdding);
    }
    @Test
    @DisplayName("Is new child is added to array?")
    void checkThatChildIsTheSame() {


        f3.addChild(newChild);
        Human[] childs =f3.getChildren();
        boolean inArray=false;
        for (Human el:childs){
            if (el == newChild){
                inArray=true;
            }
        }
        assertTrue(inArray);

    }



    @ParameterizedTest(name="{0} = {1}")
    @DisplayName("Check if it removed and back right data.")
    @CsvSource({
            "2,false",
            "1,true",
            "0,true"
    })
    void deleteChild(int index,boolean expectedResult) {
        Family fam1 = Family.builder().withMother(new Human("Yana","Hujen",1992)).withFather(new Human("Den","Topik",1992)).withChildren(new Human[]{new Human("Diana","Dovbik",2012)}).withPet(new Pet(Species.RACOON,"Kiten",6,12,new String[]{"bark","walk"}))
                .build();
        fam1.addChild(newChild);
        fam1.addChild(newChild2);
        boolean isDeleated = f3.deleteChild(index);
        System.out.println(expectedResult);
        assertEquals(isDeleated,expectedResult);
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
        int hasCode1 =f1.hashCode();
        int hashCode2 = f3.hashCode();
        assertEquals(false,hasCode1==hashCode2);
    }
    @Test
    @DisplayName("Test to string method.")
    void testToString(){
        String result = f1.toString();
        String expected = "Family{" +
                "mother=" + f1.getMother() +
                ", father=" + f1.getFather() +
                ", children=" + Arrays.toString(f1.getChildren()) +
                ", pet=" + f1.getPet() +
                '}';
        assertEquals(expected,result);
    }
}