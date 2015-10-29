package at.bookworm.misel.model;

import org.joda.time.DateTime;

import java.io.Serializable;

import lombok.Data;

/**
 *
 */
@Data
public class Misel implements Serializable {
    private DateTime birthDate;
    private static int hoursUntilStarving = 6;
    private static int hoursUntilGettingGrumpy = 3;
    private static int hoursBeingHappy = 1;
    private DateTime lastMealTime;
    private static int portionSize = 1;

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
        return !hoursReached(hoursBeingHappy);
    }

    private boolean hoursReached(int hours) {
        return DateTime.now().minusHours(hours).isAfter(lastMealTime);
    }


    public void feed(FoodStorage foodStorage) throws NotEnoughFoodException {
        foodStorage.take(portionSize);
        lastMealTime = DateTime.now();
    }

    public static Misel createMisel() {
        Misel misel = new Misel();
        misel.setBirthDate(DateTime.now());
        return misel;
    }

}