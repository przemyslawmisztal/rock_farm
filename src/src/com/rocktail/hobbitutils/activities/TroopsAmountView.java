package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;

import android.content.Context;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class TroopsAmountView extends GridLayout {
	private TextView _tileTitleTextView;
	private TextView _unitAmountTextView;
	private ImageView _tileIconImageView;
	
	public TroopsAmountView(Context context) {
		super(context);
		
		//have to find all the controls that will be used 
		this._tileIconImageView = (ImageView)findViewById(R.id.tileIconImageView);
		this._unitAmountTextView = (EditText)findViewById(R.id.unitAmountTextView);
		this._tileTitleTextView = (TextView)findViewById(R.id.tileTitleTextView);
		
	}
}
