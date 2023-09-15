import java.io.PrintStream;

public class Game {
    private final EventHandler eventHandler;
    private final Player player1;
    private final Player player2;

//    private final PrintStream printStream;
    public Game(EventHandler eventHandler, Player player1, Player player2) {
        this.eventHandler = eventHandler;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        while (true) {
            int player1Move = player1.chooseMove();
            int player2Move = player2.chooseMove();

            eventHandler.playerChoseMove(player1, player1Move);
            eventHandler.playerChoseMove(player2, player2Move);
//            verify.draw(player2, player2Move);

            if (Move.beats(player1Move, player2Move)) {
                eventHandler.gameWon(player1);
                break;
            } else if (Move.beats(player2Move, player1Move)) {
                eventHandler.gameWon(player2);
                break;
            } else {
                eventHandler.draw();
            }
        }
    }

    interface EventHandler {
        void playerChoseMove(Player player, int move);

        void gameWon(Player winner);



        void draw();
    }


}


