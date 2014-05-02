package com.rocktail.hobbitutils.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.rocktail.hobbitutils.UnitCostSettingsFragment;

public class SettingsActivity extends PreferenceActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new UnitCostSettingsFragment())
                .commit();
    }
}
