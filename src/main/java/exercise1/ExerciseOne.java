package exercise1;

public class ExerciseOne {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){
            if((i % 3 == 0) && (i % 5 == 0)){
                System.out.println("Visual Nuts");
            } else if ((i % 3 == 0) && (i % 5 !=0)) {
                System.out.println("Visual");
            } else if ((i % 3 != 0) && (i % 5 ==0)) {
                System.out.println("Nuts");
            }else{
                System.out.println(i);
            }
        }
    }
}