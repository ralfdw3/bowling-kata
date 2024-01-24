package bowling;

import static bowling.Constants.LAST_ROUND;
import static bowling.Constants.MAX_NUMBER_OF_PINS;

public class Frame {
    private Integer firstPlay = 0;
    private Integer secondPlay = 0;
    private Integer thirdPlay = 0;
    private Integer roundNumber;

    public static boolean isLastRound(Integer roundNumber) {
        return roundNumber == LAST_ROUND;
    }

    public static boolean isStrike(Integer firstPlay) {
        return firstPlay == MAX_NUMBER_OF_PINS;
    }

    public static boolean isSpare(Integer pinsDropped) {
        return pinsDropped == MAX_NUMBER_OF_PINS;
    }

    public Frame(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Frame(Integer firstPlay, Integer secondPlay, Integer thirdPlay, Integer roundNumber) {
        this.firstPlay = firstPlay;
        this.secondPlay = secondPlay;
        this.thirdPlay = thirdPlay;
        this.roundNumber = roundNumber;
    }

    public Integer getFirstPlay() {
        return firstPlay;
    }

    public Integer getSecondPlay() {
        return secondPlay;
    }

    public Integer getThirdPlay() {
        return thirdPlay;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setFirstPlay(Integer firstPlay) {
        this.firstPlay = firstPlay;
    }

    public void setSecondPlay(Integer secondPlay) {
        this.secondPlay = secondPlay;
    }

    public void setThirdPlay(Integer thirdPlay) {
        this.thirdPlay = thirdPlay;
    }

    @Override
    public String toString() {
        if (isStrike(firstPlay) && !isLastRound(roundNumber)) {
            return "[" + firstPlay + "]";
        }

        if (thirdPlay.equals(0)) {
            return "[" + firstPlay + ", " + secondPlay + "]";
        }

        return "[" + firstPlay + ", " + secondPlay + ", " + thirdPlay + "]";
    }
}
