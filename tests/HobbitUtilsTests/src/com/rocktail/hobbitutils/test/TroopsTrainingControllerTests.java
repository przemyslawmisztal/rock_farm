package com.rocktail.hobbitutils.test;

import junit.framework.Assert;
import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.controllers.TroopsTrainingController;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Class contains unit tests for {@link TroopsTrainingController}
 * @author rocktail
 *
 */
public class TroopsTrainingControllerTests extends AndroidTestCase {
	/**
	 * Simple constructor test - checking if object is in fact created
	 */
	public void testCanCreateTroopsTrainingController() {
		//arrange
		//act
		TroopsTrainingController sut = new TroopsTrainingController(
				getPlayerResources(),
				getTroopsTrainingCalculationResult());
		
		//assert
		assertNotNull(sut);
	}

	/**
	 * Checking if parameters are correctly assigned
	 */
	public void testCanPassPlayerResurces() {
		//arrange
		PlayerResources playerResources = getPlayerResources();
		TroopsTrainingCalculationResult troopsTrainingCalculationResultMock = getTroopsTrainingCalculationResult();
		
		//act
		TroopsTrainingController sut = new TroopsTrainingController(
				playerResources,
				troopsTrainingCalculationResultMock);
		
		//assert
		assertSame(playerResources, sut.getPlayerResources());
		assertSame(troopsTrainingCalculationResultMock, sut.getTroopsTrainingCalculationResult());
	}
	
	private PlayerResources getPlayerResources() {
		PlayerResources playerResources = new PlayerResources(0, 0, 0, 0);
		return playerResources;
	}
	
	private TroopsTrainingCalculationResult getTroopsTrainingCalculationResult() {
		TroopsTrainingCalculationResult troopsTrainingCalculationResult = new TroopsTrainingCalculationResult();
		return troopsTrainingCalculationResult;
	}
	
	/**
	 * Testing food amount validation
	 */
	public void testValidationReturnFalseWhenNegativeFoodIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(
				getPlayerResources(),
				getTroopsTrainingCalculationResult());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(-100, 100, 100, 100));
	}
	
	/**
	 * Testing wood amount validation
	 */
	public void testValidationReturnFalseWhenNegativeWoodIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(
				getPlayerResources(),
				getTroopsTrainingCalculationResult());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, -100, 100, 100));
	}
	
	/**
	 * Testing stone amount validation
	 */
	public void testValidationReturnFalseWhenNegativeStoneIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(
				getPlayerResources(),
				getTroopsTrainingCalculationResult());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, 100, -100, 100));
	}
	
	/**
	 * Testing ore amount validation
	 */
	public void testValidationReturnFalseWhenNegativeOreIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(
				getPlayerResources(),
				getTroopsTrainingCalculationResult());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, 100, 100, -100));
	}	
	
	/**
	 * We need to make sure that no invalid input is passed to model, that why it's important to fail when it happens
	 */
	public void testHandlingUserInputThrowsExceptionWhenValidationFails() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(
				getPlayerResources(),
				getTroopsTrainingCalculationResult());
		
		//act
		try {
			sut.handleUserInput(-100, 100, 100, 100);
		
			fail("I shouldn't get that far");
		}
		catch(Exception e) {
			Assert.assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}
	
	/**
	 * Checking if user input is passed correctly
	 */
	public void testCanHandleUserResourcesAmountInput() {
		//arrange
		int food = 100;
		int wood = 200;
		int stone = 300;
		int ore = 400;
		
		PlayerResources playerResources = new PlayerResources(0, 0, 0 ,0);
		TroopsTrainingController sut = new TroopsTrainingController(
				playerResources,
				getTroopsTrainingCalculationResult());
		
		//act
		sut.handleUserInput(food, wood, stone, ore);
		
		//assert
		assertEquals(food, sut.getPlayerResources().getFood());
		assertEquals(wood, sut.getPlayerResources().getWood());
		assertEquals(stone, sut.getPlayerResources().getStone());
		assertEquals(ore, sut.getPlayerResources().getOre());
	}
}
