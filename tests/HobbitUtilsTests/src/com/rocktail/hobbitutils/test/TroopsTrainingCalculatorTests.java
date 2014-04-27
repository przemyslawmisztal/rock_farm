package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutilst.models.PlayerResources;

/**
 * Class contains unit tests for {@link TroopsTrainingCalculator}
 * @author rocktail
 *
 */
public class TroopsTrainingCalculatorTests extends AndroidTestCase {
	
	/**
	 * Basic constructor test
	 */
	public void testCanCreateTroopsTrainingCalculator() {
		//arrange
		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(getPlayerResources(), null);
		
		//assert
		assertNotNull(sut);
	}
	
	private PlayerResources getPlayerResources() {
		PlayerResources playerResources = new PlayerResources(10000, 10000, 10000, 10000);
		
		return playerResources;
	}
	
	/**
	 * Testing if constructor properly assigns {@link PlayerResources}
	 */
	public void testPlayerResourcesAreSameWhenPassedThroughConstructor() {
		//arrange
		PlayerResources playerResources = getPlayerResources();

		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, null);
		
		//assert
		assertSame(playerResources, sut.getPlayerResources());
		//TODO: assert configuration
	}
}
