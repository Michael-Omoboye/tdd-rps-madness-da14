import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventHandlerTest {


    private ComputerPlayer ComputerPlayer;
    private HumanPlayer HumanPlayer;


    @Test
    void humanMove() {
        var printStream = mock(PrintStream.class);
        var handler = new PrinitingEventHandler(printStream);
        Game game = new Game(handler, ComputerPlayer, HumanPlayer);

        handler.playerChoseMove(new HumanPlayer(printStream, mock(Scanner.class)), Move.ROCK);
        verify(printStream).println("Player chose ROCK");
    }

    @Test
    void computerMove() {
        var printStream = mock(PrintStream.class);
        Scanner sc = new Scanner(System.in);
        var handler = new PrinitingEventHandler(printStream);

        Game game = new Game(handler, ComputerPlayer, HumanPlayer);

        handler.playerChoseMove(new ComputerPlayer(mock(Random.class)), Move.ROCK);
        verify(printStream).println("Computer chose ROCK");
    }

    @Test
    void winnerTest(){
        var printStream = mock(PrintStream.class);
        var handler = new PrinitingEventHandler(printStream);

        var player = new HumanPlayer(printStream, mock(Scanner.class));

        handler.gameWon(HumanPlayer);
        verify(printStream).println("Michael");

    }


}
