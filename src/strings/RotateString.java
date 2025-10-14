package strings;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        String concatinated = s + s;
        return concatinated.contains(goal);
    }
}
