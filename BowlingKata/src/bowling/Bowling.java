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

        pins = subtractPinsDown(pins, firstPlay);

        Integer secondPlay = roll(pins);
        frame.setSecondPlay(secondPlay);

        if (canMakeOneMorePlayInTheLastRound(firstPlay, secondPlay, roundNumber)) {
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

            totalScore = sumScores(totalScore, firstPlay, secondPlay, thirdPlay);
        }
        return frames + " = " + totalScore;
    }

    private int roll(int pinsLeft) {
        Random random = new Random();
        return random.nextInt(pinsLeft + 1);
    }

    private static int subtractPinsDown(int pins, Integer firstPlay) {
        pins -= firstPlay;
        return pins;
    }

    private static Integer sumScores(Integer totalScore, Integer firstPlay, Integer secondPlay, Integer thirdPlay) {
        totalScore += firstPlay;
        totalScore += secondPlay;
        totalScore += thirdPlay;
        return totalScore;
    }

    public static boolean canMakeOneMorePlayInTheLastRound(Integer firstPlay, Integer secondPlay, Integer roundNumber) {
        return (isStrike(firstPlay) || isSpare(firstPlay + secondPlay)) && isLastRound(roundNumber);
    }
}
