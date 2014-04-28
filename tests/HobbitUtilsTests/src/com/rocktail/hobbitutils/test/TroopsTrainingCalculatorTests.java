package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutils.vos.HobbitConfigurationVO;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutils.vos.UnitType;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Class contains unit tests for {@link TroopsTrainingCalculator}
 * @author rocktail
 *
 */
public class TroopsTrainingCalculatorTests extends AndroidTestCase {
	private int _SAMPLE_AMOUNT = 10000;
	private int _MIN_AMOUNT = 10;
	/**
	 * Basic constructor test
	 */
	public void testCanCreateTroopsTrainingCalculator() {
		//arrange
		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(getPlayerResources(), getHobbitConfiguration());
		
		//assert
		assertNotNull(sut);
	}
	
	private PlayerResources getPlayerResources() {
		//TODO: mock it
		PlayerResources playerResources = new PlayerResources(
				this._SAMPLE_AMOUNT,
				this._SAMPLE_AMOUNT, 
				this._SAMPLE_AMOUNT,
				this._SAMPLE_AMOUNT);
		
		return playerResources;
	}
	
	private HobbitConfigurationVO getHobbitConfiguration() {
		//TODO: mock it
		int costFood = this._SAMPLE_AMOUNT;
		int costWood = this._SAMPLE_AMOUNT;
		int costOre = this._SAMPLE_AMOUNT;
		int costStone = this._SAMPLE_AMOUNT;
		int might = this._SAMPLE_AMOUNT;
		String name = "testUnit";
		int tier = this._SAMPLE_AMOUNT;
		
		HobbitUnitDefinitionVO tier1Foot = new HobbitUnitDefinitionVO(name, costFood, this._MIN_AMOUNT, costStone, costOre, might, tier, UnitType.Foot);
		HobbitUnitDefinitionVO tier1Mounted = new HobbitUnitDefinitionVO(name, costFood, costWood, this._MIN_AMOUNT, costOre, might, tier, UnitType.Mounted);
		HobbitUnitDefinitionVO tier1Ranged = new HobbitUnitDefinitionVO(name, costFood, costWood, costStone, this._MIN_AMOUNT, might, tier, UnitType.Ranged);
		
		return new HobbitConfigurationVO(tier1Foot, tier1Mounted, tier1Ranged);
	}
	/**
	 * Testing if constructor properly assigns {@link PlayerResources} 
	 * and {@link HobbitUnitDefinitionVO} via {@link HobbitConfigurationVO}
	 */
	public void testPlayerResourcesAreSameWhenPassedThroughConstructor() {
		//arrange
		PlayerResources playerResources = getPlayerResources();
		HobbitConfigurationVO config = getHobbitConfiguration();
		//act
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, config);
		
		//assert
		assertSame(playerResources, sut.getPlayerResources());
		assertSame(config.getTier1FootUnit(), sut.getTier1Foot());
		assertSame(config.getTier1MountedUnit(), sut.getTier1Mounted());
		assertSame(config.getTier1RangedUnit(), sut.getTier1Ranged());
	}
	
	public void testCanCorrectlyCalculateResultWhenOnlyFootUnitIsPossible() {
		//arrange
		PlayerResources playerResources = getPlayerResources();
		
		//wood cost for foot unit is set to MIN_AMOUNT so no other unit is possible to build
		playerResources.setWood(this._MIN_AMOUNT);
		
		HobbitConfigurationVO config = getHobbitConfiguration();
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, config);
		
		//act
		TroopsTrainingCalculationResult res = sut.CalculateBestT1TroopsTraining();
		
		//assert
		assertEquals(1, res.getFootTroopsAmount());
		assertEquals(0, res.getMountedTroopsAmount());
		assertEquals(0, res.getRangedTroopsAmount());
	}
	
	public void testCanCorrectlyCalculateResultWhenOnlyMountedUnitIsPossible() {
		//arrange
		PlayerResources playerResources = getPlayerResources();
		
		//stone cost for mounted unit is set to MIN_AMOUNT so no other unit is possible to build
		playerResources.setStone(this._MIN_AMOUNT);
		
		HobbitConfigurationVO config = getHobbitConfiguration();
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, config);
		
		//act
		TroopsTrainingCalculationResult res = sut.CalculateBestT1TroopsTraining();
		
		//assert
		assertEquals(0, res.getFootTroopsAmount());
		assertEquals(1, res.getMountedTroopsAmount());
		assertEquals(0, res.getRangedTroopsAmount());
	}
	
	public void testCanCorrectlyCalculateResultWhenOnlyRangedUnitIsPossible() {
		//arrange
		PlayerResources playerResources = getPlayerResources();
		
		//stone cost for mounted unit is set to MIN_AMOUNT so no other unit is possible to build
		playerResources.setOre(this._MIN_AMOUNT);
		
		HobbitConfigurationVO config = getHobbitConfiguration();
		TroopsTrainingCalculator sut = new TroopsTrainingCalculator(playerResources, config);
		
		//act
		TroopsTrainingCalculationResult res = sut.CalculateBestT1TroopsTraining();
		
		//assert
		assertEquals(0, res.getFootTroopsAmount());
		assertEquals(0, res.getMountedTroopsAmount());
		assertEquals(1, res.getRangedTroopsAmount());
	}
}

