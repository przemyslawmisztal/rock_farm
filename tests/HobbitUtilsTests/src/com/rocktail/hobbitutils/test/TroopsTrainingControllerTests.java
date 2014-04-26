package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;
import static org.mockito.Mockito.*;

import com.rocktail.hobbitutils.controllers.TroopsTrainingController;
import com.rocktail.hobbitutilst.models.PlayerResources;

public class TroopsTrainingControllerTests extends AndroidTestCase {
	/**
	 * Simple constructor test - checking if object is in fact created
	 */
	public void testCanCreateTroopsTrainingController() {
		//arrange
		//act
		TroopsTrainingController sut = new TroopsTrainingController(GetPlayerResourcesMock());
		
		//assert
		assertNotNull(sut);
	}

	/**
	 * Checking if parameter is correctly assigned
	 */
	public void testCanPassPlayerResurces() {
		//arrange
		PlayerResources playerResourcesMock = GetPlayerResourcesMock();
		
		//act
		TroopsTrainingController sut = new TroopsTrainingController(playerResourcesMock);
		
		//assert
		assertSame(playerResourcesMock, sut.getPlayerResources());
	}
	
	private PlayerResources GetPlayerResourcesMock() {
		PlayerResources playerResourcesMock = mock(PlayerResources.class);
		return playerResourcesMock;
	}
	
	/**
	 * Testing food amount validation
	 */
	public void testValidationReturnFalseWhenNegativeFoodIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(GetPlayerResourcesMock());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(-100, 100, 100, 100));
	}
	
	/**
	 * Testing wood amount validation
	 */
	public void testValidationReturnFalseWhenNegativeWoodIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(GetPlayerResourcesMock());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, -100, 100, 100));
	}
	
	/**
	 * Testing stone amount validation
	 */
	public void testValidationReturnFalseWhenNegativeStoneIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(GetPlayerResourcesMock());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, 100, -100, 100));
	}
	
	/**
	 * Testing ore amount validation
	 */
	public void testValidationReturnFalseWhenNegativeOreIsPassed() {
		//arrange
		TroopsTrainingController sut = new TroopsTrainingController(GetPlayerResourcesMock());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, 100, 100, -100));
	}	
}
