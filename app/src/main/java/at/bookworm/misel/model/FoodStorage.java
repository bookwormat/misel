package at.bookworm.misel.model;

import java.io.Serializable;

import lombok.Data;

/**
 *
 */
@Data
public class FoodStorage implements Serializable {
    private int food;

    public int take(int amount) throws NotEnoughFoodException {
        if (amount > food) {
            throw new NotEnoughFoodException("only " + food + " food left, " + amount + " requested.");
        }
        food -= amount;
        return amount;
    }

    public static FoodStorage create() {
        FoodStorage storage = new FoodStorage();
        storage.setFood(10);
        return storage;
    }
}
