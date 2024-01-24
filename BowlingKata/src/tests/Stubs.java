package tests;

import bowling.Frame;

import java.util.ArrayList;
import java.util.List;

public class Stubs {

    public static List<Frame> playWithOnlyStrikes() {
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            frames.add(new Frame(10, 0, 0, i));
        }
        frames.add(new Frame(10, 10, 10, 9));
        return frames;
    }

    public static List<Frame> playWithOnlySpares() {
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            frames.add(new Frame(5, 5, 0, i));
        }
        frames.add(new Frame(5, 5, 5, 9));
        return frames;
    }

    public static List<Frame> playWithNoSparesOrStrike() {
        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            frames.add(new Frame(7, 1, 0, i));
        }
        return frames;
    }

    public static List<Frame> playWithOneSparesAndOneStrike() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(10, 0, 0, 0));
        frames.add(new Frame(5, 5, 0, 1));
        frames.add(new Frame(7, 1, 0, 2));
        frames.add(new Frame(7, 1, 0, 3));
        frames.add(new Frame(7, 1, 0, 4));
        frames.add(new Frame(7, 1, 0, 5));
        frames.add(new Frame(7, 1, 0, 6));
        frames.add(new Frame(7, 1, 0, 7));
        frames.add(new Frame(7, 1, 0, 8));
        frames.add(new Frame(7, 1, 0, 9));
        return frames;
    }
}
