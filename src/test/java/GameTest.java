import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    public static final ConstantMovePlayer PLAYS_ROCK = new ConstantMovePlayer(Move.ROCK);
    public static final ConstantMovePlayer PLAYS_SCISSORS = new ConstantMovePlayer(Move.SCISSORS);

    @Test
    void player1CanWin() {
        // Arrange
        Game game = new Game(PLAYS_ROCK, PLAYS_SCISSORS);
        // Act
        game.play();
        // Assert
        assertEquals(PLAYS_ROCK, game.getWinner());
    }
    @Test
    void player2CanWin() {
        // Arrange
        Game game = new Game(PLAYS_SCISSORS, PLAYS_ROCK);
        // Act
        game.play();
        // Assert
        assertEquals(PLAYS_ROCK, game.getWinner());
    }

    private static class ConstantMovePlayer implements Player {
        private final int move;

        public ConstantMovePlayer(int move) {
            this.move = move;
        }

        @Override
        public int chooseMove() {
            return move;
        }
    }
}