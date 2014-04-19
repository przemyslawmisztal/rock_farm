/**
 * 
 */
package com.rocktail.hobbitutilst.models;

/**
 * @author rocktail
 * POJO class for storing properties of Hobbit unit 
 */
public class UnitModel {
	private String _name;
	private long _costInFood;
	private long _costInWood;
	private long _costInStone;
	private long _costInOre;
	private int _might;
	private int _tier;
	
	/**
	 * Using constructor is the only way to assign values to instance of this class
	 * @param name
	 * @param costFood
	 * @param costWood
	 * @param costStone
	 * @param costOre
	 * @param might
	 * @param tier
	 */
	public UnitModel(String name,
					 long costFood,
					 long costWood,
					 long costStone,
					 long costOre,
					 int might,
					 int tier) {
		this._name = name;
		this._might = might;
		this._tier = tier;
		this._costInFood = costFood;
		this._costInOre = costOre;
		this._costInStone = costStone;
		this._costInWood = costWood;
	}
	
	public String getName() {
		return _name;
	}

	public long getCostInWood() {
		return _costInWood;
	}

	public long getCostInStone() {
		return _costInStone;
	}

	public long getCostInOre() {
		return _costInOre;
	}

	public int getMight() {
		return _might;
	}

	public int getTier() {
		return _tier;
	}

	public long getCostInFood() {
		return _costInFood;
	}
}
