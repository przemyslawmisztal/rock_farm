package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.vos.UnitType;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Compound view to display troops amount calculation result for single unit type
 * @author rocktail
 *
 */
public class TroopsAmountView extends GridLayout implements ITroopsAmountView {
	private TextView _tileTitleTextView;
	private TextView _unitAmountTextView;
	private ImageView _tileIconImageView;
	
	/**
	 * Creates instance of {@link TroopsAmountView}
	 * @param context
	 */
	public TroopsAmountView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.activity_main, this, true);
		
		//have to find all the controls that will be used 
		this._tileIconImageView = (ImageView)findViewById(R.id.tileIconImageView);
		this._unitAmountTextView = (EditText)findViewById(R.id.unitAmountTextView);
		this._tileTitleTextView = (TextView)findViewById(R.id.tileTitleTextView);
	}
	
	/**
	 * Sets {@link UnitType} that allows for displaying correct icon and text on this view
	 */
	@Override
	public void setUnitType(UnitType unitType) {
		String iconName = getIconUnitName(unitType);
		
		int resId = getResources().getIdentifier(iconName, "drawable", "com.rocktail.hobbitutils");
		this._tileIconImageView.setImageResource(resId);
		
		this._tileTitleTextView.setText(getUnitName(unitType));
	}

	/**
	 * Sets amount of units to produce
	 */
	@Override
	public void setAmount(long amount) {
		this._unitAmountTextView.setText(String.valueOf(amount));
	}
	
	/**
	 * Read unit name to display to the user
	 * @param unitType
	 * @return
	 */
	private String getUnitName(UnitType unitType) {
		switch(unitType) {
		case Foot: 
			return getResources().getString(R.string.t1_foot_elves);
		case Ranged: 
			return getResources().getString(R.string.t1_ranged_elves);
		case Mounted: 
			return getResources().getString(R.string.t1_mounted_elves);
		default: 
			return null;
		}
	}
	
	/**
	 * Gets icon name for specified {@link UnitType} so we can use it to load icon
	 * @param unitType
	 * @return
	 */
	private String getIconUnitName(UnitType unitType) {
		switch(unitType) {
			case Foot: 
				return getResources().getString(R.string.t1_foot_elves_icon_name);
			case Ranged: 
				return getResources().getString(R.string.t1_ranged_elves_icon_name);
			case Mounted: 
				return getResources().getString(R.string.t1_mounted_elves_icon_name);
			default: 
				return null;
		}
		
	}
}
