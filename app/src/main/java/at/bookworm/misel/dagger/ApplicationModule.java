package at.bookworm.misel.dagger;

import at.bookworm.misel.MiselApplication;
import dagger.Module;

/**
 *
 */
@Module
public class ApplicationModule {


    private final MiselApplication app;

    public ApplicationModule(MiselApplication app) {
        this.app = app;
    }

}
