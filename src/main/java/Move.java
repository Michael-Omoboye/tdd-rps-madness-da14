public class Move {
    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;

    public static boolean beats(int a, int b) {
        if (a == ROCK) {
            return b == SCISSORS;
        }
        if (a == PAPER) {
            return b == ROCK;
        }
        if (a == SCISSORS) {
            return b == PAPER;
        }
        return false;
    }
}
