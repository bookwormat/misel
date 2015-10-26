package at.bookworm.misel.dagger;

import at.bookworm.misel.ui.BaseActivity;
import dagger.Component;

/**
 *
 */
@Component(dependencies = {ApplicationComponent.class}, modules = ActivityModule.class)
@PerActivityScope
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);
}