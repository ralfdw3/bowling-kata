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

    public List<Integer> playRound(Integer roundNumber) {
        List<Integer> score = new ArrayList<>();
        int pins = MAX_NUMBER_OF_PINS;
        Integer firstPlay = roll(pins);

        if (allPinsAreDown(firstPlay) && !isLastRound(roundNumber)) {
            score.add(firstPlay);
            return score;
        }
        score.add(firstPlay);
        pins -= firstPlay;

        Integer secondPlay = roll(pins);
        score.add(secondPlay);

        if ((isStrike(firstPlay) || isSpare(pins)) && isLastRound(roundNumber)) {
            Integer thirdPlay = roll(MAX_NUMBER_OF_PINS);
            score.add(thirdPlay);
        }

        return score;
    }

    public String sumTotalScore(List<List<Integer>> allFrames) {
        Integer totalScore = 0;

        for (int frame = 0; frame < allFrames.size(); frame++) {
            List<Integer> play = allFrames.get(frame);

            if (isLastRoundAndHasThreePlays(frame, play)) {
                totalScore += play.get(0);
                totalScore += play.get(1);
                totalScore += play.get(2);

            } else if (isStrike(play.get(0))) {
                totalScore += 30;

            } else if (isSpare(play.get(0) + play.get(1))) {
                totalScore += 20;

            } else {
                totalScore += play.get(0);
                totalScore += play.get(1);
            }
        }
        System.out.println(allFrames + " = " + totalScore);
        return allFrames + " = " + totalScore;
    }

    private int roll(int pinsLeft) {
        Random random = new Random();
        return random.nextInt(pinsLeft + 1);
    }

    private boolean allPinsAreDown(int pinsDown) {
        return isStrike(pinsDown);
    }

    private static boolean isLastRound(Integer roundNumber) {
        return roundNumber == LAST_ROUND;
    }

    private static boolean isLastRoundAndHasThreePlays(int frame, List<Integer> play) {
        return isLastRound(frame) && play.size() == 3;
    }

    private static boolean isStrike(Integer firstPlay) {
        return firstPlay == MAX_NUMBER_OF_PINS;
    }

    private static boolean isSpare(Integer pinsDropped) {
        return pinsDropped == MAX_NUMBER_OF_PINS;
    }
}
