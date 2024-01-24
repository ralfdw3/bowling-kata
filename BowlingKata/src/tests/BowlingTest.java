package tests;

import bowling.Bowling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.Stubs.*;

class BowlingTest {
    Bowling bowling = new Bowling();

    @Test
    void whenAllPlaysAreStrikeResultShouldBe300() {
        String result = bowling.score(playWithOnlyStrikes());

        assertEquals("[[10], [10], [10], [10], [10], [10], [10], [10], [10], [10, 10, 10]] = 300", result);
    }

    @Test
    void whenAllPlaysAreSpareseResultShouldBe150() {
        String result = bowling.score(playWithOnlySpares());

        assertEquals("[[5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5, 5]] = 195", result);
    }

    @Test
    void whenDoesntHaveStrikeOrSpareResultShouldBe80() {
        String result = bowling.score(playWithNoSparesOrStrike());

        assertEquals("[[7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1]] = 80", result);
    }
    @Test
    void whenHaveOneStrikeAndOneSpareResultShouldBe114() {
        String result = bowling.score(playWithOneSparesAndOneStrike());

        assertEquals("[[10], [5, 5], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1], [7, 1]] = 114", result);
    }
}