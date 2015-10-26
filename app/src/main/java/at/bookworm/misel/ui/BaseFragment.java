package at.bookworm.misel.ui;

import android.support.v4.app.Fragment;

import at.bookworm.misel.dagger.ActivityComponent;
import at.bookworm.misel.dagger.ApplicationComponent;
import at.bookworm.misel.dagger.HasComponent;

/**
 *
 */
public class BaseFragment extends Fragment {

    public ActivityComponent getActivityComponent() {
        return ((HasComponent<ActivityComponent>) getActivity()).getComponent();
    }

    public ApplicationComponent getApplicationComponent() {
        return ((HasComponent<ApplicationComponent>) getActivity().getApplication()).getComponent();
    }

}
