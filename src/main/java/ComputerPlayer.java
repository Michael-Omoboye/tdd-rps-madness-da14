import java.util.Random;

public class ComputerPlayer implements Player {
    private final Random random;

    public ComputerPlayer(Random random) {
        this.random = random;
    }

    @Override
    public int chooseMove() {
        return random.nextInt(3);
    }
}
