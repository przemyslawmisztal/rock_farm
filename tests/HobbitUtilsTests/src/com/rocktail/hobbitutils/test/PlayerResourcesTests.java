package com.rocktail.hobbitutils.test;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutilst.models.PlayerResources;

/**
 * Class containing various tests for PlayerResources class
 * @author rocktail
 *
 */
public class PlayerResourcesTests extends AndroidTestCase {
	private long _food = 150;
	private long _wood = 200;
	private long _stone = 50;
	private long _ore = 300;
	
	/**
	 * Simple test to see if constructor works
	 */
	public void testCanCreatePlayerResources() {
		//arrange
		PlayerResources sut;
		
		//act
		sut = new PlayerResources(this._food, this._wood, this._stone, this._ore);
		
		//assert
		assertNotNull(sut);
	}
	
	/**
	 * Checking if assigned resource values are in fact really correctly assigned
	 */
	public void testCreatePlayerResourcesWithCorrectValues() {
		//arrange
		PlayerResources sut;
		
		//act
		sut = new PlayerResources(this._food, this._wood, this._stone, this._ore);
		
		//assert
		assertEquals(this._food, sut.getFood());
		assertEquals(this._ore, sut.getOre());
		assertEquals(this._stone, sut.getStone());
		assertEquals(this._wood, sut.getWood());
	}
}
