package at.bookworm.misel.model;

import org.joda.time.DateTime;

import java.io.Serializable;

import lombok.Data;

/**
 *
 */
@Data
public class Misel implements Serializable {
    private static int hoursUntilStarving = 6;
    private static int hoursUntilGettingGrumpy = 3;
    private static int hoursBeingHappy = 1;
    private DateTime lastMealTime;
    private String message;

    public Mood mood() {
        if (isStarving()) {
            return Mood.sad;
        }

        if (isWellFed()) {
            return Mood.happy;
        }

        return Mood.neutral;
    }

    private boolean isStarving() {
        return hoursReached(hoursUntilStarving);
    }

    private boolean isWellFed() {
        return hoursReached(hoursBeingHappy);
    }

    private boolean isGrumpy() {
        return hoursReached(hoursUntilGettingGrumpy);
    }

    private boolean hoursReached(int hours) {
        return DateTime.now().minusHours(hours).isBefore(lastMealTime);
    }

    public String message() {
        if (isStarving()) {
            return selectStarvingMessage();
        }
        if (isWellFed()) {
            return selectWellFedMessage();
        }
        if (isGrumpy()) {
            return selectGrumpyMessage();
        }

        return selectRandomMessage();

    }

    private String selectRandomMessage() {
        return "This is a placeholder for a random message";
    }

    private String selectGrumpyMessage() {
        return "This is a placeholder for a grumpy message";
    }

    private String selectWellFedMessage() {
        return "This is a placeholder for a well fed message";
    }

    private String selectStarvingMessage() {
        return "This is a placeholder for a starving message";
    }

}
