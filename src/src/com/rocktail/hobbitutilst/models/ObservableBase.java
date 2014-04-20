package com.rocktail.hobbitutilst.models;

/**
 * Base interface for classes that take the role of observer.
 * Using interface instead of Java class allows for composition (over inheritance)
 * @author rocktail
 *
 * @param <T>
 */
public interface ObservableBase<T> {

	void addListener(OnChangeListener<T> listener);
	void removeListener(OnChangeListener<T> listener);
}