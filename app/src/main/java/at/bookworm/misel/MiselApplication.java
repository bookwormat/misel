package at.bookworm.misel;

import android.app.Application;

import at.bookworm.misel.dagger.ApplicationComponent;
import at.bookworm.misel.dagger.ApplicationModule;
import at.bookworm.misel.dagger.HasComponent;

/**
 *
 */
public class MiselApplication extends Application implements HasComponent<ApplicationComponent> {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = at.bookworm.misel.dagger.DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.injectApplication(this);
    }

    @Override
    public ApplicationComponent getComponent() {
        return component;
    }
}
