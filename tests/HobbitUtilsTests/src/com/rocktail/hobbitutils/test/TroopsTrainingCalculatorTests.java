package com.rocktail.hobbitutils.test;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.UnitType;

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
				getPlayerResources(),
				getUnitModels());
		
		//assert
		assertNotNull(sut);
	}
	
	private PlayerResources getPlayerResources() {
		PlayerResources playerResources = new PlayerResources(10000, 10000, 10000, 10000);
		
		return playerResources;
	}
	
	/**
	 * Preparing sample unit models to test if calculations are correct
	 * @return
	 */
	private List<HobbitUnitDefinitionVO> getUnitModels() {
		List<HobbitUnitDefinitionVO> unitModels = new ArrayList<HobbitUnitDefinitionVO>();
		
		HobbitUnitDefinitionVO footTroops = new HobbitUnitDefinitionVO("foot", 150, 220, 100, 50, 4, 1, UnitType.Foot);
		HobbitUnitDefinitionVO rangedTroops = new HobbitUnitDefinitionVO("ranged", 150, 55, 200, 100, 4, 1, UnitType.Ranged);
		HobbitUnitDefinitionVO mountedTroops = new HobbitUnitDefinitionVO("mounted", 150, 110, 50, 200, 4, 1, UnitType.Mounted);
		
		unitModels.add(footTroops);
		unitModels.add(rangedTroops);
		unitModels.add(mountedTroops);
		
		return unitModels;
	}
	/**
	 * Testing if constructor properly assigns {@link PlayerResources}
	 */
	public void testPlayerResourcesAreSameWhenPassedThroughConstructor() {
		//arrange
		PlayerResources playerResources = getPlayerResources();
		List<HobbitUnitDefinitionVO> unitModels = getUnitModels();
		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, unitModels);
		
		//assert
		assertSame(playerResources, sut.getPlayerResources());
		assertSame(unitModels, sut.getUnits());
	}
}
