package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bowling {

    public static final int LAST_ROUND = 9;
    public static final int MAX_NUMBER_OF_PINS = 10;

    public String execute() {
        List<List<Integer>> allScores = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allScores.add(playRound(i));
        }
        return sumTotalScore(allScores);
    }

    public String execute(List<List<Integer>> allScores) {
        return sumTotalScore(allScores);
    }

    private String sumTotalScore(List<List<Integer>> allFrames) {
        Integer totalScore = 0;

        for (int frame = 0; frame < allFrames.size(); frame++) {
            List<Integer> play = allFrames.get(frame);

            Integer firstPlayOfFrame = play.get(0);

            if (isLastRound(frame) && play.size() == 3) {
                totalScore += firstPlayOfFrame;
                totalScore += play.get(1);
                totalScore += play.get(2);

            } else if (isStrike(firstPlayOfFrame)) {
                totalScore += 30;

            } else if (isSpare(firstPlayOfFrame + play.get(1))) {
                totalScore += 20;

            } else {
                totalScore += firstPlayOfFrame;
                totalScore += play.get(1);
            }
        }
        return allFrames + " = " + totalScore;
    }

    public List<Integer> playRound(Integer roundNumber) {
        List<Integer> score = new ArrayList<>();
        Integer pins = MAX_NUMBER_OF_PINS;
        Integer firstPlay = roll(pins);

        if (isLastRound(roundNumber)) {
            return playLastRound();
        }

        if (allPinsAreDown(firstPlay)) {
            score.add(firstPlay);
            return score;
        }
        score.add(firstPlay);
        pins -= firstPlay;

        Integer secondPlay = roll(pins);
        score.add(secondPlay);

        return score;
    }

    private List<Integer> playLastRound() {
        List<Integer> score = new ArrayList<>();
        Integer pins = MAX_NUMBER_OF_PINS;
        Integer firstPlay = roll(pins);

        if (!allPinsAreDown(firstPlay)) {
            pins -= firstPlay;
        }
        score.add(firstPlay);

        Integer secondPlay = roll(pins);
        score.add(secondPlay);
        pins -= secondPlay;

        if (isStrike(firstPlay) || isSpare(pins)) {
            Integer thirdPlay = roll(MAX_NUMBER_OF_PINS);
            score.add(thirdPlay);
        }

        return score;
    }

    private static boolean isStrike(Integer firstPlay) {
        return firstPlay == MAX_NUMBER_OF_PINS;
    }

    private static boolean isSpare(Integer pinsDropped) {
        return pinsDropped == MAX_NUMBER_OF_PINS;
    }

    private static boolean isLastRound(Integer roundNumber) {
        return roundNumber == LAST_ROUND;
    }

    private boolean allPinsAreDown(int pinsDown) {
        return isStrike(pinsDown);
    }

    private int roll(int pinsLeft) {
        Random random = new Random();
        return random.nextInt(pinsLeft + 1);
    }
}
