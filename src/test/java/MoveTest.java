import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    @Test
    void rockShouldBeatScissors() {
        assertTrue(Move.beats(Move.ROCK, Move.SCISSORS));
    }

    @Test
    void scissorsShouldNotBeatRock() {
        assertFalse(Move.beats(Move.SCISSORS, Move.ROCK));
    }

    @Test
    void scissorsShouldBeatPaper() {
        assertTrue(Move.beats(Move.SCISSORS, Move.PAPER));
    }

}
