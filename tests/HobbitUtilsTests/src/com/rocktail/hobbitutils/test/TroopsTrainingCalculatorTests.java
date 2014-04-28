package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutils.vos.HobbitConfigurationVO;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutils.vos.UnitType;
import com.rocktail.hobbitutilst.models.PlayerResources;

/**
 * Class contains unit tests for {@link TroopsTrainingCalculator}
 * @author rocktail
 *
 */
public class TroopsTrainingCalculatorTests extends AndroidTestCase {
	private int _SAMPLE_AMOUNT = 10000;
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
		UnitType unitType = UnitType.Foot;
		
		HobbitUnitDefinitionVO tier1Foot = new HobbitUnitDefinitionVO(name, costFood, costWood, costStone, costOre, might, tier, unitType);
		HobbitUnitDefinitionVO tier1Mounted = new HobbitUnitDefinitionVO(name, costFood, costWood, costStone, costOre, might, tier, unitType);
		HobbitUnitDefinitionVO tier1Ranged = new HobbitUnitDefinitionVO(name, costFood, costWood, costStone, costOre, might, tier, unitType);
		
		return new HobbitConfigurationVO(tier1Foot, tier1Mounted, tier1Ranged);
		
		
	}
	/**
	 * Testing if constructor properly assigns {@link PlayerResources}
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
}
