package com.rocktail.hobbitutils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class UnitCostSettingsFragment extends PreferenceFragment 
	implements OnSharedPreferenceChangeListener {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
	
	/**
	 * Displaying current setting value in summary field
	 */
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
	    Preference pref = findPreference(key);

	    if (pref instanceof EditTextPreference) {
	    	EditTextPreference listPref = (EditTextPreference) pref;
	        pref.setSummary(listPref.getText());
	    }
	}
	
	@Override
	public void onResume() {
        super.onResume();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}
