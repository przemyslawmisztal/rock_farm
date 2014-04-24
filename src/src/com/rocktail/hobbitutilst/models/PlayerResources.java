package com.rocktail.hobbitutilst.models;

import java.util.Observable;

/**
 * Contains info about resources available to player
 * @author rocktail
 *
 */
public class PlayerResources extends Observable {
	private long _food;
	private long _wood;
	private long _stone;
	private long _ore;
	
	/**
	 * Default constructor initializes properties with provided values
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
	
	public void setFood(long food) {
		this._food = food;
	}
	
	/**
	 * Returns amount of wood player has available
	 * @return
	 */
	public long getWood() {
		return _wood;
	}
	
	public void setWood(long wood) {
		this._food = wood;
	}
	
	/**
	 * Returns amount of stone player has available
	 * @return
	 */
	public long getStone() {
		return _stone;
	}
	
	public void setSood(long stone) {
		this._food = stone;
	}
	
	/**
	 * Returns amount of ore player has available
	 * @return
	 */
	public long getOre() {
		return _ore;
	}
	
	public void setOre(long ore) {
		this._food = ore;
	}
}
