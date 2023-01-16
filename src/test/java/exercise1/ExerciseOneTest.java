package exercise1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseOneTest {

    @Test
    @DisplayName("Verify if prints Visual")
    public void verifyIfPrintsVisual(){
        assertEquals("Visual",printNumber(3));
    }
    @Test
    @DisplayName("Verify if prints Nuts")
    public void verifyIfPrintsNuts(){assertEquals("Nuts",printNumber(50));}
    @Test
    @DisplayName("Verify if prints Visual Nuts")
    public void verifyWithPrintsVisualNuts(){assertEquals("Visual Nuts",printNumber(15));}

    @Test
    @DisplayName("Verify if prints not divisible by 3 and 5")
    public void verifyIfNotPrintsVisualNuts(){
        assertEquals("is not divisible by 3 and 5",printNumber(97));
    }

    /**
     * Verify the number if its divisible by 3 and 5
     * @param number
     * @return a string that shows a message if the number is divisible by 3 and 5
     */
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