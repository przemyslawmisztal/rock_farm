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
	 * Default constructor initialises properties with provided values
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
		this.setFood(food);
		this.setOre(ore);
		this.setStone(stone);
		this.setWood(wood);
	}
	/**
	 * Returns amount of food player has available
	 * @return
	 */
	public long getFood() {
		return this._food;
	}
	
	/**
	 * Sets amount of food player has available
	 * @param food
	 */
	public void setFood(long food) {
		this._food = food;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Returns amount of wood player has available
	 * @return
	 */
	public long getWood() {
		return this._wood;
	}
	
	/**
	 * Sets amount of wood player has available
	 * @param wood
	 */
	public void setWood(long wood) {
		this._wood = wood;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Returns amount of stone player has available
	 * @return
	 */
	public long getStone() {
		return _stone;
	}
	
	/**
	 * Sets amount of stone player has available
	 * @param stone
	 */
	public void setStone(long stone) {
		this._stone = stone;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Returns amount of ore player has available
	 * @return
	 */
	public long getOre() {
		return _ore;
	}
	
	/**
	 * Sets amount of ore player has available
	 * @param ore
	 */
	public void setOre(long ore) {
		this._ore = ore;
		setChanged();
		notifyObservers();
	}
}
