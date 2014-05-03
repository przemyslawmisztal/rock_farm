package com.rocktail.hobbitutils.test;

import junit.framework.Assert;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.test.mock.MockContext;
import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.utils.AppConfigReader;
import com.rocktail.hobbitutils.vos.HobbitConfigurationVO;

/**
 * Class containing tests for configuration reader 
 * @author rocktail
 *
 */
public class AppConfigReaderTests extends AndroidTestCase {
	/**
	 * Basic constructor test
	 */
	public void testCanCreateReader() {
		//arrange
		//act
		AppConfigReader sut = new AppConfigReader();
		
		//assert
		assertNotNull(sut);
	}
}
