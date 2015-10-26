package at.bookworm.misel.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import at.bookworm.misel.MiselApplication;
import at.bookworm.misel.storage.MiselStorage;
import at.bookworm.misel.storage.SharedPrefsMiselStorage;
import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class ApplicationModule {


    private static final String SHARED_PREFS = "prefs";
    private final MiselApplication app;

    public ApplicationModule(MiselApplication app) {
        this.app = app;
    }


    @Provides
    @Singleton
    public MiselStorage provideMiselStorage() {
        SharedPreferences prefs = app.getApplicationContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        return new SharedPrefsMiselStorage(prefs);
    }


}
