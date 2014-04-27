package com.rocktail.hobbitutils;

import java.util.List;

import com.rocktail.hobbitutils.utils.Simplex;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutils.vos.UnitType;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Handles calculations that provide answer what troops to train to spend most of the resources  
 * @author rocktail
 *
 */
public class TroopsTrainingCalculator {
	private PlayerResources _playerResources;
	private List<HobbitUnitDefinitionVO> _units;
	/**
	 * Creates new instance of {@link TroopsTrainingCalculator}
	 * @param playerResources
	 */
	public TroopsTrainingCalculator(PlayerResources playerResources,
			List<HobbitUnitDefinitionVO> unitsToProduce) {
		this.setPlayerResources(playerResources);
		this.setUnits(unitsToProduce);
	}

	/**
	 * Calculates best T1 troops training queue that spend most of the resources
	 * @return
	 */
	public TroopsTrainingCalculationResult CalculateBestT1TroopsTraining() {
		HobbitUnitDefinitionVO t1_1 = this._units.get(0);
		HobbitUnitDefinitionVO t1_2 = this._units.get(1);
		HobbitUnitDefinitionVO t1_3 = this._units.get(2);
		
		//as units may come in any order we need to make sure we know which is which
		int footIndex = GetFootUnitIndex();
		int mountedIndex = GetMountedUnitIndex();
		int rangedIndex = GetRangedUnitIndex();
		
        try {       	
            double[][] A = PrepareMatrixForSimplex_A(t1_1, t1_2, t1_3);
            double[] c = PrepareMatrixForSimplex_C(t1_1, t1_2, t1_3);
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
	
	private int GetFootUnitIndex() {
		for(int i = 0; i < this._units.size(); i++) {
			HobbitUnitDefinitionVO unitModel = this._units.get(i);
			
			if (unitModel.getUnitType().equals(UnitType.Foot)) {
				return i;
			}
		}
		
		return -1;
	}
	
	private int GetRangedUnitIndex() {
		for(int i = 0; i < this._units.size(); i++) {
			HobbitUnitDefinitionVO unitModel = this._units.get(i);
			
			if (unitModel.getUnitType().equals(UnitType.Ranged)) {
				return i;
			}
		}
		
		return -1;
	}
	
	private int GetMountedUnitIndex() {
		for(int i = 0; i < this._units.size(); i++) {
			HobbitUnitDefinitionVO unitModel = this._units.get(i);
			
			if (unitModel.getUnitType().equals(UnitType.Mounted)) {
				return i;
			}
		}
		
		return -1;
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

	/**
	 * Gets list of units we want to produce
	 * @return
	 */
	public List<HobbitUnitDefinitionVO> getUnits() {
		return _units;
	}

	/**
	 * Sets list of units that we want to produce
	 * @param _units
	 */
	private void setUnits(List<HobbitUnitDefinitionVO> _units) {
		this._units = _units;
	}

}
