public class Game {
    private final Player player1;
    private final Player player2;
    private Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        int player1Move = player1.chooseMove();
        int player2Move = player2.chooseMove();

        if (Move.beats(player1Move, player2Move)) {
            winner = player1;
        } else if (Move.beats(player2Move, player1Move)) {
            winner = player2;
        }
    }

    public Player getWinner() {
        return winner;
    }
}
