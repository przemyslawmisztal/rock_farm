package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

public class TroopsTrainingCalculationResultTests extends AndroidTestCase {
	/**
	 * Checking if constructor works
	 */
	public void testCanCreateTroopsTrainingCalculationResult() {
		//arrange
		//act
		TroopsTrainingCalculationResult sut = new TroopsTrainingCalculationResult();
		
		//assert
		assertNotNull(sut);
	}
}
