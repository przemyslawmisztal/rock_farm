package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.activities.IMainActivity;
import com.rocktail.hobbitutils.activities.ITroopsTrainingView;
import com.rocktail.hobbitutils.controllers.TroopsTrainingResourcesPresenter;

/**
 * Class contains unit tests for {@link TroopsTrainingResourcesPresenter}
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
		TroopsTrainingResourcesPresenter sut = new TroopsTrainingResourcesPresenter(
				getMainActivity(),
				getTroopsTrainingView());
		
		//assert
		assertNotNull(sut);
	}
	
	private IMainActivity getMainActivity() {
		IMainActivity mainActivity = null;
		return mainActivity;
	}
	
	private ITroopsTrainingView getTroopsTrainingView() {
		ITroopsTrainingView troopsTrainingView = null;
		return troopsTrainingView;
	}
	
	/**
	 * Testing food amount validation
	 */
	public void testValidationReturnFalseWhenNegativeFoodIsPassed() {
		//arrange
		TroopsTrainingResourcesPresenter sut = new TroopsTrainingResourcesPresenter(
				getMainActivity(),
				getTroopsTrainingView());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(-100, 100, 100, 100));
	}
	
	/**
	 * Testing wood amount validation
	 */
	public void testValidationReturnFalseWhenNegativeWoodIsPassed() {
		//arrange
		TroopsTrainingResourcesPresenter sut = new TroopsTrainingResourcesPresenter(
				getMainActivity(),
				getTroopsTrainingView());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, -100, 100, 100));
	}
	
	/**
	 * Testing stone amount validation
	 */
	public void testValidationReturnFalseWhenNegativeStoneIsPassed() {
		//arrange
		TroopsTrainingResourcesPresenter sut = new TroopsTrainingResourcesPresenter(
				getMainActivity(),
				getTroopsTrainingView());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, 100, -100, 100));
	}
	
	/**
	 * Testing ore amount validation
	 */
	public void testValidationReturnFalseWhenNegativeOreIsPassed() {
		//arrange
		TroopsTrainingResourcesPresenter sut = new TroopsTrainingResourcesPresenter(
				getMainActivity(),
				getTroopsTrainingView());
		
		//act
		//assert
		assertFalse(sut.ValidateUserInput(100, 100, 100, -100));
	}	
}
