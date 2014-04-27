package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Class contains unit tests for {@link TroopsTrainingCalculationResult}iningCalculationResult
 * @author rocktail
 *
 */
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
