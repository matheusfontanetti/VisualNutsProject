package exercise1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseOneTest {

    @Test
    public void verifyIfPrintsVisual(){
        assertEquals("Visual",printNumber(3));
    }
    @Test
    public void verifyIfPrintsNuts(){
        assertEquals("Nuts",printNumber(50));
    }    @Test
    public void verifyWithPrintsVisualNuts(){
        assertEquals("Visual Nuts",printNumber(15));
    }    @Test
    public void verifyIfNotPrintsVisualNuts(){
        assertEquals("is not divisible by 3 and 5",printNumber(97));
    }

    @Disabled
    public String printNumber(int number){
            if((number % 3 == 0) && (number % 5 == 0)){
                return "Visual Nuts";
            } else if ((number % 3 == 0) && (number % 5 !=0)) {
                return "Visual";
            } else if ((number % 3 != 0) && (number % 5 ==0)) {
                return "Nuts";
            }
            return "is not divisible by 3 and 5";
        }
}