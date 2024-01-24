package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static bowling.Constants.MAX_NUMBER_OF_PINS;
import static bowling.Frame.*;

public class Bowling {

    public void execute() {
        List<Frame> allFrames = new ArrayList<>();

        for (int round = 0; round < 10; round++) {
            Frame frame = playRound(new Frame(round));

            allFrames.add(frame);
        }
        score(allFrames);
    }

    public Frame playRound(Frame frame) {
        Integer roundNumber = frame.getRoundNumber();
        int pins = MAX_NUMBER_OF_PINS;

        frame.setFirstPlay(roll(pins));
        Integer firstPlay = frame.getFirstPlay();

        if (isStrike(firstPlay) && !isLastRound(roundNumber)) {
            return frame;
        }

        pins -= firstPlay;

        frame.setSecondPlay(roll(pins));

        if (canMakeOneMorePlayInTheLastRound(firstPlay, pins, roundNumber)) {
            frame.setThirdPlay(roll(MAX_NUMBER_OF_PINS));
        }

        return frame;
    }

    public String score(List<Frame> frames) {
        Integer totalScore = 0;

        for (int roundNumber = 0; roundNumber < frames.size(); roundNumber++) {
            Frame frame = frames.get(roundNumber);
            Integer firstPlay = frame.getFirstPlay();
            Integer secondPlay = frame.getSecondPlay();
            Integer thirdPlay = frame.getThirdPlay();

            if (isStrike(firstPlay) && !isLastRound(roundNumber)) {
                totalScore += 30;
                continue;
            }

            if (isSpare(firstPlay + secondPlay) && !isLastRound(roundNumber)) {
                totalScore += 20;
                continue;
            }

            totalScore += firstPlay;
            totalScore += secondPlay;
            totalScore += thirdPlay;
        }
        System.out.println(frames + " = " + totalScore);
        return frames + " = " + totalScore;
    }

    private int roll(int pinsLeft) {
        Random random = new Random();
        return random.nextInt(pinsLeft + 1);
    }

    private static boolean canMakeOneMorePlayInTheLastRound(Integer firstPlay, int pins, Integer roundNumber) {
        return (isStrike(firstPlay) || isSpare(pins)) && isLastRound(roundNumber);
    }
}
