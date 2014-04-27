package com.rocktail.hobbitutils.utils;

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
	 * Gets app configuration
	 * @return
	 */
	public static HobbitConfigurationVO getHobbitConfiguration() {
		//TODO: config file is a lie
		HobbitUnitDefinitionVO tier1Foot = new HobbitUnitDefinitionVO("Elven Militia", 150, 220, 100, 50, 4, 1, UnitType.Foot);
		HobbitUnitDefinitionVO tier1Mounted = new HobbitUnitDefinitionVO("Mounted Elves", 150, 110, 50, 200, 4, 1, UnitType.Mounted);
		HobbitUnitDefinitionVO tier1Ranged = new HobbitUnitDefinitionVO("Elven Archers", 150, 55, 200, 100, 4, 1, UnitType.Ranged);
		
		HobbitConfigurationVO config = new HobbitConfigurationVO(tier1Foot, tier1Mounted, tier1Ranged); 
		
		return config;
	}
}