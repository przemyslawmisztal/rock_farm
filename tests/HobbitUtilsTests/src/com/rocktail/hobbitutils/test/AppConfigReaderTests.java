package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.utils.AppConfigReader;

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
