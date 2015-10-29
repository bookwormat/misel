package at.bookworm.misel.ui;

import android.content.Context;

import java.util.Random;

import at.bookworm.misel.R;
import at.bookworm.misel.model.FoodStorage;
import at.bookworm.misel.model.Misel;

/**
 *
 */
public class MiselUi {
    private final FoodStorage foodStorage;
    private Misel misel;
    private Context context;
    private Random random = new Random();

    private static int[] neutralImages = new int[]{R.drawable.state1, R.drawable.state2, R.drawable.state3, R.drawable.state5};
    private static int[] sadImages = new int[]{R.drawable.state4};
    private static int[] happyImages = new int[]{R.drawable.state6, R.drawable.state7};

    public MiselUi(Context context, Misel misel, FoodStorage foodStorage) {
        this.context = context.getApplicationContext();
        this.misel = misel;
        this.foodStorage = foodStorage;
    }

    public String getRemainingFood() {
        return this.foodStorage.getFood() + "";
    }

    public String getLastMealTime() {
        if (misel.getLastMealTime() == null) {
            return "Never";
        }
        return misel.getLastMealTime().toString();
    }

    public String getMessage() {
        switch (misel.mood()) {
            case happy:
                return selectHappyMessage();
            case sad:
                return selectSadMessage();
            case neutral:
            default:
                return selectNeutralMessage();
        }
    }

    public int getImageRes() {
        switch (misel.mood()) {
            case happy:
                return selectHappyImage();
            case sad:
                return selectSadImage();
            case neutral:
            default:
                return selectNeutralImage();
        }
    }

    private int selectNeutralImage() {
        return selectRandomFromArray(neutralImages);
    }

    private int selectSadImage() {
        return selectRandomFromArray(sadImages);
    }

    private int selectHappyImage() {
        return selectRandomFromArray(happyImages);
    }

    private int selectRandomFromArray(int[] array) {
        return array[random.nextInt(array.length)];
    }

    private String selectNeutralMessage() {
        return "This is a placeholder for a random message";
    }

    private String selectSadMessage() {
        return "This is a placeholder for a grumpy message";
    }

    private String selectHappyMessage() {
        return "This is a placeholder for a well fed message";
    }


}
