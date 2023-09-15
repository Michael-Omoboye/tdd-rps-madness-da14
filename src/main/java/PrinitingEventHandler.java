import java.io.PrintStream;

public class PrinitingEventHandler implements Game.EventHandler {

    private final PrintStream printStream;
    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;


    public PrinitingEventHandler(PrintStream printStream) {
        this.printStream = printStream;
    }


    @Override
    public void playerChoseMove(Player player, int move) {
        String moveString = "";

        if (move == 0) {
            moveString = "ROCK";
        }
        if (move == 1) {
            moveString = "PAPER";
        }
        if (move == 2) {
            moveString = "SCISSORS";
        }

        if (player.getClass() == ComputerPlayer.class) {
            String movePlayed = "Computer chose " + moveString;
            printStream.println(movePlayed);
        } else {
            String movePlayed = "Player chose " + moveString;
            printStream.println(movePlayed);
        }
    }


    @Override
    public void gameWon(Player winner) {
        if (winner.getClass() == HumanPlayer.class) {
            printStream.println(humanPlayer.getName());
        } else {
            printStream.println("try again?");
        }
    }

    @Override
    public void draw() {
            printStream.println("its a draw");
    }
}
