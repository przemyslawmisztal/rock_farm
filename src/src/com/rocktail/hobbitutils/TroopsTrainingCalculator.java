package com.rocktail.hobbitutils;

import java.util.List;

import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.UnitModel;

/**
 * Handles calculations that provide answer what troops to train to spend most of the resources  
 * @author rocktail
 *
 */
public class TroopsTrainingCalculator {
	private PlayerResources _playerResources;
	private List<UnitModel> _units;
	/**
	 * Creates new instance of {@link TroopsTrainingCalculator}
	 * @param playerResources
	 */
	public TroopsTrainingCalculator(PlayerResources playerResources,
			List<UnitModel> unitsToProduce) {
		this.setPlayerResources(playerResources);
		this.setUnits(unitsToProduce);
	}

	/**
	 * Gets {@link PlayerResources}
	 * @return
	 */
	public PlayerResources getPlayerResources() {
		return this._playerResources;
	}

	/**
	 * Sets {@link PlayerResources}
	 * @param _playerResources
	 */
	private void setPlayerResources(PlayerResources _playerResources) {
		this._playerResources = _playerResources;
	}

	/**
	 * Gets list of units we want to produce
	 * @return
	 */
	public List<UnitModel> getUnits() {
		return _units;
	}

	/**
	 * Sets list of units that we want to produce
	 * @param _units
	 */
	private void setUnits(List<UnitModel> _units) {
		this._units = _units;
	}

}
