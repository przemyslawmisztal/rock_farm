package com.rocktail.hobbitutilst.models;

import java.util.ArrayList;

/**
 * Purpose of this class is to notify observers when properties have changed.
 * @author rocktail
 *
 * @param <T>
 */
public class ModelObservable<T> implements ObservableBase<T> {
		
	private final ArrayList<OnChangeListener<T>> listeners = new ArrayList<OnChangeListener<T>>();
		
	/**
	 * Adds listener which we are going notify when properties change
	 */
	public void addListener(OnChangeListener<T> listener) {
			synchronized (listeners) {
				listeners.add(listener);
			}
	}
	
	/**
	 * Remove existing listener
	 */
	public void removeListener(OnChangeListener<T> listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}
		
	/**
	 * Notify each of the registered observers about property change
	 * @param model
	 */
	protected void notifyObservers(final T model) {
		synchronized (listeners) {
			for (OnChangeListener<T> listener : listeners) {
				listener.onChange(model);
			}
		}
	}
		
}