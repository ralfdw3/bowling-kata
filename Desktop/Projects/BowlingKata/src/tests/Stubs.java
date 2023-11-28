package tests;

import java.util.ArrayList;
import java.util.List;

public class Stubs {

    public static List<List<Integer>> playWithOnlyStrikes() {
        List<List<Integer>> frames = new ArrayList<>();
        List<Integer> plays = new ArrayList<>();
        plays.add(10);

        for (int i = 0; i < 9; i++) {
            frames.add(plays);
        }

        List<Integer> tenthFrame = new ArrayList<>();
        tenthFrame.add(10);
        tenthFrame.add(10);
        tenthFrame.add(10);
        frames.add(tenthFrame);
        return frames;
    }

    public static List<List<Integer>> playWithOnlySpares() {
        List<List<Integer>> frames = new ArrayList<>();
        List<Integer> plays = new ArrayList<>();
        plays.add(5);
        plays.add(5);

        for (int i = 0; i < 9; i++) {
            frames.add(plays);
        }

        List<Integer> tenthFrame = new ArrayList<>();
        tenthFrame.add(5);
        tenthFrame.add(5);
        tenthFrame.add(5);
        frames.add(tenthFrame);
        return frames;
    }
}
