package at.bookworm.misel;

import android.app.Application;

import at.bookworm.misel.dagger.ApplicationComponent;
import at.bookworm.misel.dagger.ApplicationModule;

/**
 *
 */
public class MiselApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = at.bookworm.misel.DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.injectApplication(this);
    }


}
