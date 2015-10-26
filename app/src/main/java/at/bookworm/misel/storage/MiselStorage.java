package at.bookworm.misel.storage;

import at.bookworm.misel.model.Misel;

/**
 *
 */
public interface MiselStorage {

    public Misel loadMisel();

    public void storeMisel(Misel misel);

}
