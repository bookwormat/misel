package at.bookworm.misel.storage;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import at.bookworm.misel.model.Misel;

/**
 *
 */
public class SharedPrefsMiselStorage implements MiselStorage {

    private static final String TAG = SharedPrefsMiselStorage.class.getName();
    private static final String PREF_MISEL = "pref.misel";
    private final SharedPreferences prefs;
    final Gson gson;

    public SharedPrefsMiselStorage(SharedPreferences prefs) {
        this.prefs = prefs;
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(DateTime.class, new DateTimeTypeConverter());
        this.gson = builder.create();
    }

    @Override
    public Misel loadMisel() {
        if (!prefs.contains(PREF_MISEL)) {
            storeMisel(Misel.createMisel());
        }
        String json = prefs.getString(PREF_MISEL, null);
        Log.d(TAG, "loading misel: " + json);
        Misel misel = gson.fromJson(json, Misel.class);
        return misel;
    }

    @Override
    public void storeMisel(Misel misel) {
        String json = gson.toJson(misel);
        Log.d(TAG, "saving misel: " + json);
        prefs.edit().putString(PREF_MISEL, json).commit();
    }
}
