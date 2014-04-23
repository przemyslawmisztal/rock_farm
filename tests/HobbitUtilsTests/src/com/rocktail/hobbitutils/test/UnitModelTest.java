package com.rocktail.hobbitutils.test;

import com.rocktail.hobbitutilst.models.UnitModel;

public class UnitModelTest extends android.test.AndroidTestCase {
	private String _name = "Terminator";
	private long _wood = 150;
	private long _food = 100;
	private long _ore = 200;
	private long _stone = 50;
	private int _might = 4;
	private int _tier = 1;
	
	public void testCanCreateUnitModel() {
		//arrange
		UnitModel sut;
		
		//act
		sut = new UnitModel(this._name,
							this._food,
							this._wood,
							this._stone,
							this._ore,
							this._might,
							this._tier);
		
		//assert
		assertNotNull(sut);
	}
	
	public void testCreatedUnitModelHasCorrectPropertiesAssigned() {
		//arrange
		UnitModel sut;
		
		//act
		sut = new UnitModel(this._name,
							this._food,
							this._wood,
							this._stone,
							this._ore,
							this._might,
							this._tier);
		
		//assert
		assertEquals(this._name, sut.getName());
		assertEquals(this._food, sut.getCostInFood());
		assertEquals(this._wood, sut.getCostInWood());
		assertEquals(this._stone, sut.getCostInStone());
		assertEquals(this._ore, sut.getCostInOre());
		assertEquals(this._might, sut.getMight());
		assertEquals(this._tier, sut.getTier());
	}
	
}
