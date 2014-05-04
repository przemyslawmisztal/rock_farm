package com.rocktail.hobbitutils.activities;

import android.content.Context;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

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
	
	public PlayerResourceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAmount(long resourceAmount) {
		this._resourceAmountEditText.setText(String.valueOf(resourceAmount));
		
	}

	@Override
	public void setResourceName(String resourceName) {
		this._tileTitleTextView.setText(resourceName);
		
	}

	@Override
	public void setResourceIcon(String iconName) {
		int resId = getResources().getIdentifier(iconName, "drawable", "com.rocktail.hobbitutils");
		this._tileIconImageView.setImageResource(resId);
		
	}

}
