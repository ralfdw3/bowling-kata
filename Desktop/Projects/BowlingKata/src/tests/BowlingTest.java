package tests;

import bowling.Bowling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.Stubs.playWithOnlySpares;
import static tests.Stubs.playWithOnlyStrikes;

class BowlingTest {
    Bowling bowling = new Bowling();

    @Test
    void whenAllPlaysAreStrikeResultShouldBe300() {
        String result = bowling.execute(playWithOnlyStrikes());

        assertEquals("[[10], [10], [10], [10], [10], [10], [10], [10], [10], [10, 10, 10]] = 300", result);
    }

    @Test
    void whenAllPlaysAreSpareseResultShouldBe150() {
        String result = bowling.execute(playWithOnlySpares());

        assertEquals("[[5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5], [5, 5, 5]] = 195", result);
    }
}