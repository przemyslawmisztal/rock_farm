/**
 * 
 */
package com.rocktail.hobbitutils.vos;


/**
 * @author rocktail
 * Class for storing properties of Hobbit unit 
 */
public class HobbitUnitDefinitionVO {
	private String _name;
	private long _costInFood;
	private long _costInWood;
	private long _costInStone;
	private long _costInOre;
	private int _might;
	private int _tier;
	private UnitType _unitType;
	private String _INVALID_UNIT_TYPE_MSG = "No or invalid unit type provided.";
	
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
	public HobbitUnitDefinitionVO(String name,
					 long costFood,
					 long costWood,
					 long costStone,
					 long costOre,
					 int might,
					 int tier,
					 UnitType unitType) {
		this._name = name;
		this._might = might;
		this._tier = tier;
		this._costInFood = costFood;
		this._costInOre = costOre;
		this._costInStone = costStone;
		this._costInWood = costWood;
		this.setUnitType(unitType);
	}
	
	/**
	 * Get name of the unit
	 * @return
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Get unit cost in wood
	 * @return
	 */
	public long getCostInWood() {
		return _costInWood;
	}

	/**
	 * Get unit cost in stone
	 * @return
	 */
	public long getCostInStone() {
		return _costInStone;
	}

	/**
	 * Get unit cost in ore
	 * @return
	 */
	public long getCostInOre() {
		return _costInOre;
	}

	/**
	 * Get unit might
	 * @return
	 */
	public int getMight() {
		return _might;
	}

	/**
	 * Get unit tier
	 * @return
	 */
	public int getTier() {
		return _tier;
	}

	/**
	 * Get unit cost in food
	 * @return
	 */
	public long getCostInFood() {
		return _costInFood;
	}

	/**
	 * Get unit type
	 * @return
	 */
	public UnitType getUnitType() {
		return _unitType;
	}

	/**
	 * Set unit type.
	 * @param unitType
	 */
	private void setUnitType(UnitType unitType) {
		if (unitType == null || unitType == UnitType.Invalid) {
			throw new IllegalArgumentException(this._INVALID_UNIT_TYPE_MSG);
		}
		
		this._unitType = unitType;
	}
}
