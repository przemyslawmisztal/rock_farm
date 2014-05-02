package com.rocktail.hobbitutils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;

public class UnitCostSettingsFragment extends PreferenceFragment 
	implements OnSharedPreferenceChangeListener {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        
        //we want to load current values initially
		for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
        	initSummary(getPreferenceScreen().getPreference(i));
		}
    }
	
	/**
	 * Assign setting values to their respective summary fields 
	 */
	private void initSummary(Preference preference) {
		if (preference instanceof PreferenceCategory) {
            PreferenceCategory pCategory = (PreferenceCategory) preference;
            
            for (int i = 0; i < pCategory.getPreferenceCount(); i++) {
                initSummary(pCategory.getPreference(i));
            }
        } else {
        	if (preference instanceof EditTextPreference) {
    	    	updateSummary((EditTextPreference) preference);
        	}
        }
	}
	
	/**
	 * Displaying current setting value in summary field
	 */
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
	    Preference pref = findPreference(key);

	    if (pref instanceof EditTextPreference) {
	    	updateSummary((EditTextPreference) pref);
	    }
	}
	
	private void updateSummary(EditTextPreference editTextPreference) {
		editTextPreference.setSummary(editTextPreference.getText());
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
