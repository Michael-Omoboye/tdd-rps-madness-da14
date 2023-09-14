import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    public static final ConstantMovePlayer PLAYS_ROCK = new ConstantMovePlayer(Move.ROCK);
    public static final ConstantMovePlayer PLAYS_SCISSORS = new ConstantMovePlayer(Move.SCISSORS);

    private final SpyEventHandler eventHandler = new SpyEventHandler();


    @Test
    void player1MoveReported() {
        // Arrange
        Game game = new Game(eventHandler, PLAYS_ROCK, PLAYS_SCISSORS);
        // Act
        game.play();
        // Assert
        eventHandler.assertMoveReported(PLAYS_ROCK, Move.ROCK);
    }
    @Test
    void player2MoveReported() {
        // Arrange
        Game game = new Game(eventHandler, PLAYS_ROCK, PLAYS_SCISSORS);
        // Act
        game.play();
        // Assert
        eventHandler.assertMoveReported(PLAYS_SCISSORS, Move.SCISSORS);
    }

    @Test
    void player1CanWin() {
        // Arrange
        Game game = new Game(eventHandler, PLAYS_ROCK, PLAYS_SCISSORS);
        // Act
        game.play();
        // Assert
        eventHandler.assertWinner(PLAYS_ROCK);
    }

    @Test
    void player2CanWin() {
        // Arrange
        Game game = new Game(eventHandler, PLAYS_SCISSORS, PLAYS_ROCK);
        // Act
        game.play();
        // Assert
        eventHandler.assertWinner(PLAYS_ROCK);
    }

    @Test
    void drawsCanBeReported() {
        // Arrange
        Game game = new Game(eventHandler, PLAYS_SCISSORS, PLAYS_SCISSORS);
        // Act
        game.play();
        // Assert
        eventHandler.assertDrawReported();
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

    private static class SpyEventHandler implements Game.EventHandler {
        private Player reportedWinner;
        private final Map<Player, Integer> reportedMoves = new HashMap<>();
        private boolean draw = false;

        @Override
        public void playerChoseMove(Player player, int move) {
            reportedMoves.put(player, move);
        }

        @Override
        public void gameWon(Player winner) {
            reportedWinner = winner;
        }

        @Override
        public void draw() {
            draw = true;
        }

        void assertWinner(Player expectedWinner) {
            assertEquals(expectedWinner, reportedWinner);
        }

        public void assertMoveReported(ConstantMovePlayer expectedPlayer, int expectedMove) {
            assertTrue(reportedMoves.containsKey(expectedPlayer));
            assertEquals(expectedMove, reportedMoves.get(expectedPlayer));
        }

        public void assertDrawReported() {
            assertTrue(draw);
        }
    }
}