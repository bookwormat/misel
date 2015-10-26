package at.bookworm.misel.dagger;

import at.bookworm.misel.ui.BaseActivity;
import at.bookworm.misel.ui.MiselActivityFragment;
import dagger.Component;

/**
 *
 */
@Component(dependencies = {ApplicationComponent.class}, modules = ActivityModule.class)
@PerActivityScope
public interface ActivityComponent {

    void inject(BaseActivity component);

    void inject(MiselActivityFragment component);
}