package A3_LoginExercise.utils;

public class Verification {
    public static String getV(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append((int)(Math.random() * 9));
        }
        return sb.toString();
    }
}
