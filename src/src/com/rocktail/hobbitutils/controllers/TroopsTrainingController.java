package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutilst.models.PlayerResources;

public class TroopsTrainingController extends ControllerBase {

	private PlayerResources _playerResources;
	
	public TroopsTrainingController(PlayerResources playerResources) {
		this._playerResources = playerResources;
	}
	@Override
	public boolean handleMessage(int what, Object data) {
		// TODO Auto-generated method stub
		return false;
	}

}
