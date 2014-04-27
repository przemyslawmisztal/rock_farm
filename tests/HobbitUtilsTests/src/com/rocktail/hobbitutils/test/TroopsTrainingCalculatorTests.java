package com.rocktail.hobbitutils.test;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.UnitModel;

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
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(
				GetPlayerResourcesMock(),
				GetUnitModels());
		
		//assert
		assertNotNull(sut);
	}
	
	private PlayerResources GetPlayerResourcesMock() {
		return mock(PlayerResources.class);
	}
	
	private List<UnitModel> GetUnitModels() {
		List<UnitModel> unitModels = new ArrayList<UnitModel>();
		
		return unitModels;
	}
	/**
	 * Testing if constructor properly assigns {@link PlayerResources}
	 */
	public void testPlayerResourcesAreSameWhenPassedThroughConstructor() {
		//arrange
		PlayerResources playerResources = GetPlayerResourcesMock();
		List<UnitModel> unitModels = GetUnitModels();
		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, unitModels);
		
		//assert
		assertSame(playerResources, sut.getPlayerResources());
		assertSame(playerResources, sut.getUnits());
	}
}
