import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static java.util.Arrays.stream;
import static org.mockito.Mockito.*;

class GameTest {

//    public static final ConstantMovePlayer PLAYS_ROCK = new ConstantMovePlayer(Move.ROCK);
//    public static final ConstantMovePlayer PLAYS_SCISSORS = new ConstantMovePlayer(Move.SCISSORS);
//    public static final ConstantMovePlayer PLAYS_PAPER = new ConstantMovePlayer(Move.PAPER);

    private final Game.EventHandler eventHandler = mock();
    Player playScissors = mock(Player.class);
    Player playRock = mock(Player.class);
    Player playPaper = mock(Player.class);

    private final Player mockRock = mock(MoveListPlayer.class);

    @BeforeEach
    void assignMove() {
        when(playScissors.chooseMove()).thenReturn(Move.SCISSORS);
        when(playRock.chooseMove()).thenReturn(Move.ROCK);
        when(playPaper.chooseMove()).thenReturn(Move.PAPER);

        when(mockRock.chooseMove()).thenReturn(Move.ROCK, Move.PAPER);
    }

    @Test
    void player1MoveReported() {
        // Arrange
        Game game = new Game(eventHandler, playRock, playScissors);
        // Act
        game.play();
        // Assert
        verify(eventHandler).playerChoseMove(playRock, Move.ROCK);
    }

    @Test
    void player2MoveReported() {
        // Arrange
        Game game = new Game(eventHandler, playRock, playScissors);
        // Act
        game.play();
        // Assert
        verify(eventHandler).playerChoseMove(playScissors, Move.SCISSORS);
    }

    @Test
    void player1CanWin() {
        // Arrange
        Game game = new Game(eventHandler, playRock, playScissors);
        // Act
        game.play();
        // Assert
        verify(eventHandler).gameWon(playRock);
    }

    @Test
    void player2CanWin() {
        // Arrange
        Game game = new Game(eventHandler, playRock, playPaper);
        // Act
        game.play();
        // Assert
        verify(eventHandler).gameWon(playPaper);
    }

    @Test
    void drawsCanBeReported() {
        // Arrange
        Game game = new Game(eventHandler, mockRock, playRock);
        // Act
        game.play();
        // Assert
        verify(eventHandler).draw();

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


    private static class MoveListPlayer implements Player {
        private final Iterator<Integer> iterator;

        MoveListPlayer(int... moves) {
            iterator = stream(moves).boxed().iterator();
        }

        @Override
        public int chooseMove() {
            return iterator.next();
        }


    }
}