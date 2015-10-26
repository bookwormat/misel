package at.bookworm.misel.dagger;

import at.bookworm.misel.ui.BaseActivity;
import dagger.Module;

@Module
public class ActivityModule {
    private BaseActivity activity;
    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }
}
