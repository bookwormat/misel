package at.bookworm.misel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import at.bookworm.misel.dagger.ActivityComponent;
import at.bookworm.misel.dagger.ActivityModule;
import at.bookworm.misel.dagger.ApplicationComponent;
import at.bookworm.misel.dagger.DaggerActivityComponent;
import at.bookworm.misel.dagger.HasComponent;

/**
 *
 */
public class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {


    private ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        component = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
        component.inject(this);
        super.onCreate(savedInstanceState);
    }

    ApplicationComponent getApplicationComponent() {
        return ((HasComponent<ApplicationComponent>) getApplication()).getComponent();
    }

    @Override
    public ActivityComponent getComponent() {
        return component;
    }


}
