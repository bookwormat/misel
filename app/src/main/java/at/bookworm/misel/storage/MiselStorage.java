package at.bookworm.misel.storage;

import at.bookworm.misel.model.FoodStorage;
import at.bookworm.misel.model.Misel;

/**
 *
 */
public interface MiselStorage {

    Misel loadMisel();

    void storeMisel(Misel misel);

    void storeFoodStorage(FoodStorage foodStorage);

    FoodStorage loadFoodStorage();

}
