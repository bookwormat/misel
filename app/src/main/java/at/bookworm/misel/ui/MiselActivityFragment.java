package at.bookworm.misel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import at.bookworm.misel.R;
import at.bookworm.misel.model.FoodStorage;
import at.bookworm.misel.model.Misel;
import at.bookworm.misel.storage.MiselStorage;

/**
 * A placeholder fragment containing a simple view.
 */
public class MiselActivityFragment extends BaseFragment {

    private static final String STATE_MISEL = "state.misel";
    @Inject
    MiselStorage miselStorage;

    private FoodStorage foodStorage;
    private Misel misel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        misel = miselStorage.loadMisel();
        foodStorage = miselStorage.loadFoodStorage();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        miselStorage.storeMisel(misel);
        miselStorage.storeFoodStorage(foodStorage);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_misel, container, false);
        TextView messageTV = (TextView) view.findViewById(R.id.message);
        messageTV.setText(misel.getMessage());

        TextView birthDayTV = (TextView) view.findViewById(R.id.birthdayMessage);
        birthDayTV.setText("I was born on " + misel.getBirthDate().toString());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
