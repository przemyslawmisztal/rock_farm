package com.rocktail.hobbitutilst.models;

import java.util.Observable;

public class TroopsTrainingCalculationResult extends Observable {
	private long _footTroopsAmount;
	private long _rangedTroopsAmount;
	private long _mountedTroopsAmount;
	
	/**
	 * Gets calculated amount of foot troops to produce
	 * @return
	 */
	public long getFootTroopsAmount() {
		return _footTroopsAmount;
	}
	
	/**
	 * Sets amount of foot troops
	 * @param _footTroopsAmount
	 */
	public void setFootTroopsAmount(long _footTroopsAmount) {
		this._footTroopsAmount = _footTroopsAmount;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Gets calculated amount of ranged troops to produce
	 * @return
	 */
	public long getRangedTroopsAmount() {
		return _rangedTroopsAmount;
	}
	
	/**
	 * Sets amount of ranged troops
	 * @param _rangedTroopsAmount
	 */
	public void setRangedTroopsAmount(long _rangedTroopsAmount) {
		this._rangedTroopsAmount = _rangedTroopsAmount;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Gets calculated amount of mounted troops to produce
	 * @return
	 */
	public long getMountedTroopsAmount() {
		return _mountedTroopsAmount;
	}
	
	/**
	 * Sets amount of mounted troops
	 * @param _mountedTroopsAmount
	 */
	public void setMountedTroopsAmount(long _mountedTroopsAmount) {
		this._mountedTroopsAmount = _mountedTroopsAmount;
		setChanged();
		notifyObservers();
	}
}
