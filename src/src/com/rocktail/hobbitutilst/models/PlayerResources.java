package com.rocktail.hobbitutilst.models;

/**
 * Contains info about resources available to player
 * @author rocktail
 *
 */
public class PlayerResources extends ModelObservable<PlayerResources> {
	private long _food;
	private long _wood;
	private long _stone;
	private long _ore;
	
	/**
	 * Constructor is the only way to assign values to resources
	 *  
	 * @param food
	 * @param wood
	 * @param stone
	 * @param ore
	 */
	public PlayerResources(
			long food,
			long wood,
			long stone,
			long ore) {
		this._food = food;
		this._ore = ore;
		this._stone = stone;
		this._wood = wood;
	}
	/**
	 * Returns amount of food player has available
	 * @return
	 */
	public long getFood() {
		return _food;
	}
	
	/**
	 * Returns amount of wood player has available
	 * @return
	 */
	public long getWood() {
		return _wood;
	}
	
	/**
	 * Returns amount of stone player has available
	 * @return
	 */
	public long getStone() {
		return _stone;
	}
	
	/**
	 * Returns amount of ore player has available
	 * @return
	 */
	public long getOre() {
		return _ore;
	}
}
