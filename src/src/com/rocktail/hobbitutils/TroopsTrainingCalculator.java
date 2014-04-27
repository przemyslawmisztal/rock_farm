package com.rocktail.hobbitutils;

import com.rocktail.hobbitutils.utils.Simplex;
import com.rocktail.hobbitutils.vos.HobbitConfigurationVO;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Handles calculations that provide answer what troops to train to spend most of the resources  
 * @author rocktail
 *
 */
public class TroopsTrainingCalculator {
	private PlayerResources _playerResources;
	private HobbitUnitDefinitionVO _tier1Foot;
	private HobbitUnitDefinitionVO _tier1Ranged;
	private HobbitUnitDefinitionVO _tier1Mounted;
	
	/**
	 * Creates new instance of {@link TroopsTrainingCalculator}
	 * @param playerResources
	 */
	public TroopsTrainingCalculator(PlayerResources playerResources,
			HobbitConfigurationVO hobbitConfiguration) {
		this.setPlayerResources(playerResources);
		
		this.setTier1Foot(hobbitConfiguration.getTier1FootUnit());
		this.setTier1Mounted(hobbitConfiguration.getTier1MountedUnit());
		this.setTier1Ranged(hobbitConfiguration.getTier1RangedUnit());
	}

	/**
	 * Calculates best T1 troops training queue that spend most of the resources
	 * @return
	 */
	public TroopsTrainingCalculationResult CalculateBestT1TroopsTraining() {

		//as units may come in any order we need to make sure we know which is which
		int footIndex = 0;
		int mountedIndex = 1;
		int rangedIndex = 2;
		
        try {       	
            double[][] A = PrepareMatrixForSimplex_A(
            		this._tier1Foot,
            		this._tier1Mounted,
            		this._tier1Ranged);
            
            double[] c = PrepareMatrixForSimplex_C(this._tier1Foot, this._tier1Mounted, this._tier1Ranged);
            double[] b = PrepareMatrixForSimplex_B();
                
            Simplex lp = new Simplex(A, b, c);

            //we are interested only in primal values (x)
            double[] x = lp.primal();
            
            //first three values are the ones that we are searching for
            //they come out in same order as in input tables
            double mountedResult = x[mountedIndex];
            double footResult = x[footIndex];
            double rangedResult = x[rangedIndex];
            	
            return SimplexToResult(mountedResult, footResult, rangedResult);
        }
        catch (ArithmeticException e) { 
        	e.printStackTrace();
        	
        	return null;
        }
	}

	private double[] PrepareMatrixForSimplex_B() {
		double[] b = { this._playerResources.getFood(), this._playerResources.getWood(), this._playerResources.getStone(), this._playerResources.getOre() };
		
		return b;
	}
	private double[] PrepareMatrixForSimplex_C(HobbitUnitDefinitionVO t1_1, HobbitUnitDefinitionVO t1_2, HobbitUnitDefinitionVO t1_3) {
		double[] c = { t1_1.getMight(), t1_2.getMight(), t1_2.getMight(), 0, 0, 0, 0 };
		
		return c;
	}
	
	private double[][] PrepareMatrixForSimplex_A(HobbitUnitDefinitionVO t1_1, HobbitUnitDefinitionVO t1_2, HobbitUnitDefinitionVO t1_3) {
		double[][] A =  {
            { t1_1.getCostInFood(), t1_2.getCostInFood(), t1_3.getCostInFood(), 1, 0, 0, 0},
            { t1_1.getCostInWood(), t1_2.getCostInWood(), t1_3.getCostInWood(),  0, 1, 0, 0},
            { t1_1.getCostInStone(),  t1_2.getCostInStone(), t1_2.getCostInStone(), 0, 0, 1, 0},
            { t1_1.getCostInOre(), t1_2.getCostInOre(),  t1_2.getCostInOre(), 0, 0, 0, 1},
        };
		
		return A;
	}
	
	/**
	 * Converts double values received from simplex calculations to integers
	 * @param mounted
	 * @param foot
	 * @param ranged
	 * @return
	 */
	private TroopsTrainingCalculationResult SimplexToResult(double mounted, double foot,
			double ranged) {
		TroopsTrainingCalculationResult result = new TroopsTrainingCalculationResult();
		
		result.setFootTroopsAmount((int)foot);
		result.setMountedTroopsAmount((int)mounted);
		result.setRangedTroopsAmount((int)ranged);
		
		return result;
	}

	/**
	 * Gets {@link PlayerResources}
	 * @return
	 */
	public PlayerResources getPlayerResources() {
		return this._playerResources;
	}

	/**
	 * Sets {@link PlayerResources}
	 * @param _playerResources
	 */
	private void setPlayerResources(PlayerResources _playerResources) {
		this._playerResources = _playerResources;
	}

	private void setTier1Foot(HobbitUnitDefinitionVO _tier1foot) {
		this._tier1Foot = _tier1foot;
	}

	public void setTier1Ranged(HobbitUnitDefinitionVO _tier1Ranged) {
		this._tier1Ranged = _tier1Ranged;
	}

	public void setTier1Mounted(HobbitUnitDefinitionVO _tier1Mounted) {
		this._tier1Mounted = _tier1Mounted;
	}

}
