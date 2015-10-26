package at.bookworm.misel.dagger;

import javax.inject.Singleton;

import at.bookworm.misel.MiselApplication;
import dagger.Component;

/**
 *
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void injectApplication(MiselApplication application);

}