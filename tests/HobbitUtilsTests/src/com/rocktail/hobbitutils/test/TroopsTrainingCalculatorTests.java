package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutilst.models.PlayerResources;
import static org.mockito.Mockito.*;

/**
 * Class contains unit tests for TroopsTrainingCalculator
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
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(GetPlayerResourcesMock());
		
		//assert
		assertNotNull(sut);
	}
	
	private PlayerResources GetPlayerResourcesMock() {
		return mock(PlayerResources.class);
	}
	/**
	 * Testing if constructor properly assigns {@link PlayerResources}
	 */
	public void testPlayerResourcesAreSameWhenPassedThroughConstructor() {
		//arrange
		PlayerResources playerResources = GetPlayerResourcesMock();
		
		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources);
		
		//assert
		assertSame(playerResources, sut.getPlayerResources());
		
	}
}
