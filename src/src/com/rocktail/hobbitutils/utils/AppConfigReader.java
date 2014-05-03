package com.rocktail.hobbitutils.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.rocktail.hobbitutils.vos.HobbitConfigurationVO;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutils.vos.UnitType;

/**
 * Class contains methods to read app configuration file 
 * @author rocktail
 *
 */
public class AppConfigReader {
	/**
	 * Reads application configuration and returns configuration object to be used by tools
	 * @return
	 */
	public static HobbitConfigurationVO getHobbitConfiguration(Context context) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		
		long t1FootFood = sharedPreferences.getLong("pref_t1_foot_food_cost", 0);
		long t1FootWood = sharedPreferences.getLong("pref_t1_foot_wood_cost", 0);
		long t1FootStone = sharedPreferences.getLong("pref_t1_foot_stone_cost", 0);
		long t1FootOre = sharedPreferences.getLong("pref_t1_foot_ore_cost", 0);
		long t1RangedFood = sharedPreferences.getLong("pref_t1_ranged_food_cost", 0);
		long t1RangedWood = sharedPreferences.getLong("pref_t1_ranged_wood_cost", 0);
		long t1RangedStone = sharedPreferences.getLong("pref_t1_ranged_stone_cost", 0);
		long t1RangedOre = sharedPreferences.getLong("pref_t1_ranged_ore_cost", 0);
		long t1MountedFood = sharedPreferences.getLong("pref_t1_mounted_food_cost", 0);
		long t1MountedWood = sharedPreferences.getLong("pref_t1_mounted_wood_cost", 0);
		long t1MountedStone = sharedPreferences.getLong("pref_t1_mounted_stone_cost", 0);
		long t1MountedOre = sharedPreferences.getLong("pref_t1_mounted_ore_cost", 0);
		
		
		HobbitUnitDefinitionVO tier1Foot = new HobbitUnitDefinitionVO(
				"Elven Militia",
				t1FootFood,
				t1FootWood,
				t1FootStone,
				t1FootOre
				,
				4,
				1,
				UnitType.Foot);
		
		HobbitUnitDefinitionVO tier1Mounted = new HobbitUnitDefinitionVO(
				"Mounted Elves",
				t1MountedFood,
				t1MountedWood,
				t1MountedStone,
				t1MountedOre,
				4,
				1,
				UnitType.Mounted);
		
		HobbitUnitDefinitionVO tier1Ranged = new HobbitUnitDefinitionVO(
				"Elven Archers",
				t1RangedFood,
				t1RangedWood,
				t1RangedStone,
				t1RangedOre,
				4,
				1,
				UnitType.Ranged);
		
		HobbitConfigurationVO config = new HobbitConfigurationVO(tier1Foot, tier1Mounted, tier1Ranged); 
		
		return config;
	}
}