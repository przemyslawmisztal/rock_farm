package com.rocktail.hobbitutils.vos;


/**
 * Class used to store hobbit game related parameters
 * @author rocktail
 *
 */
public class HobbitConfigurationVO {
	private HobbitUnitDefinitionVO _tier1FootUnit;
	private HobbitUnitDefinitionVO _tier1MountedUnit;
	private HobbitUnitDefinitionVO _tier1RangedUnit;
	
	/**
	 * Created new instance of configuration value object
	 * @param tier1foot
	 * @param tier1mounted
	 * @param tier1ranged
	 */
	public HobbitConfigurationVO(
			HobbitUnitDefinitionVO tier1foot,
			HobbitUnitDefinitionVO tier1mounted,
			HobbitUnitDefinitionVO tier1ranged) {
		this.setTier1FootUnit(tier1foot);
		this.setTier1MountedUnit(tier1mounted);
		this.setTier1RangedUnit(tier1ranged);
		
	}

	/**
	 * Reads parameters of tier 1 foot unit
	 * @return
	 */
	public HobbitUnitDefinitionVO getTier1FootUnit() {
		return _tier1FootUnit;
	}

	private void setTier1FootUnit(HobbitUnitDefinitionVO _tier1FootUnit) {
		this._tier1FootUnit = _tier1FootUnit;
	}

	/**
	 * Reads parameters of tier 1 mounted unit
	 * @return
	 */
	public HobbitUnitDefinitionVO getTier1MountedUnit() {
		return _tier1MountedUnit;
	}

	private void setTier1MountedUnit(HobbitUnitDefinitionVO _tier1MountedUnit) {
		this._tier1MountedUnit = _tier1MountedUnit;
	}

	/**
	 * Reads parameters of tier 1 ranged unit
	 * @return
	 */
	public HobbitUnitDefinitionVO getTier1RangedUnit() {
		return _tier1RangedUnit;
	}

	private void setTier1RangedUnit(HobbitUnitDefinitionVO _tier1RangedUnit) {
		this._tier1RangedUnit = _tier1RangedUnit;
	}
}
