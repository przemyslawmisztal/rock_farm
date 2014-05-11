package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.vos.ResourceType;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

/**
 * Compound view for player resource input 
 * @author rocktail
 *
 */
public class PlayerResourceView extends GridLayout
	implements IPlayerResourceView {
	
	private TextView _tileTitleTextView;
	private EditText _resourceAmountEditText;
	private ImageView _tileIconImageView;
	
	private ResourceType _resourceType;
	/**
	 * Creates instance of {@link PlayerResourceView} and finds needed controls
	 * @param context
	 */
	public PlayerResourceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_player_resource, this, true);
		
		//have to find all the controls that will be used 
		this._tileIconImageView = (ImageView)findViewById(R.id.tileIconImageView);
		this._resourceAmountEditText = (EditText)findViewById(R.id.resourceAmountEditText);
		this._tileTitleTextView = (TextView)findViewById(R.id.tileTitleTextView);
	}

	/**
	 * Sets amount of resource
	 */
	@Override
	public void setAmount(long resourceAmount) {
		this._resourceAmountEditText.setText(String.valueOf(resourceAmount));
	}

	/**
	 * Enables view to display correct icon for provided {@link ResourceType}
	 */
	@Override
	public void setResource(ResourceType resourceType) {
		this._resourceType = resourceType;
		
		String iconName = getIconResourceName(resourceType);
		
		int resId = getResources().getIdentifier(iconName, "drawable", "com.rocktail.hobbitutils");
		this._tileIconImageView.setImageResource(resId);
		
		this._tileTitleTextView.setText(getResourceName(resourceType));
		
	}

	/**
	 * Return resource name based on {@link ResourceType}
	 * @param resourceType
	 * @return
	 */
	private String getResourceName(ResourceType resourceType) {
		switch(resourceType) {
		case Food: 
			return getResources().getString(R.string.resource_food);
		case Ore: 
			return getResources().getString(R.string.resource_ore);
		case Stone: 
			return getResources().getString(R.string.resource_stone);
		case Wood: 
			return getResources().getString(R.string.resource_wood);			
		default: 
			return null;
		}
	}

	/**
	 * Gets icon resource name so we can find and display correct icon 
	 * @param resourceType
	 * @return
	 */
	private String getIconResourceName(ResourceType resourceType) {
		switch(resourceType) {
		case Food: 
			return getResources().getString(R.string.resource_food_icon);
		case Ore: 
			return getResources().getString(R.string.resource_ore_icon);
		case Stone: 
			return getResources().getString(R.string.resource_stone_icon);
		case Wood: 
			return getResources().getString(R.string.resource_wood_icon);			
		default: 
			return null;
		}
	}

	/**
	 * Returns resource type of this tile 
	 */
	@Override
	public ResourceType getResourceType() {
		return this._resourceType;
	}

	/**
	 * Return user entered amount
	 */
	@Override
	public long getAmount() {
		return Long.parseLong(this._resourceAmountEditText.getText().toString());
	}

}

