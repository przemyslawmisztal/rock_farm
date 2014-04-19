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
	private long _costFood;
	private long _costWood;
	private long _costStone;
	private long _costOre;
	private int _might;
	private int _tier;
	
	public UnitModel(String name,
					 long costFood,
					 long costWood,
					 long costStone,
					 long costOre,
					 int might,
					 int tier) {
		this._name = name;
		this.set_might(might);
		this.set_tier(tier);
		this._costFood = costFood;
		this.set_costOre(costOre);
		this.set_costStone(costStone);
		this.setCostWood(costWood);
	}
	
	public String getName() {
		return _name;
	}

	public long getCostWood() {
		return _costWood;
	}

	public long getCostStone() {
		return _costStone;
	}

	public long getCostOre() {
		return _costOre;
	}

	public int getMight() {
		return _might;
	}

	public int getTier() {
		return _tier;
	}
}
