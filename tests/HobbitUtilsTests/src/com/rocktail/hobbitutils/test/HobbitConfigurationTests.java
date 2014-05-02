package com.rocktail.hobbitutils.test;
import org.easymock.EasyMock;

import android.test.AndroidTestCase;

import com.rocktail.hobbitutils.vos.HobbitConfigurationVO;
import com.rocktail.hobbitutils.vos.HobbitUnitDefinitionVO;
import com.rocktail.hobbitutils.vos.UnitType;

/**
 * Contains tests for {@link HobbitConfigurationVO}
 * @author rocktail
 *
 */
public class HobbitConfigurationTests extends AndroidTestCase {
	/**
	 * Testing if constructor works
	 */
	public void testCanCreateConfiguration() {
		//arrange
		//act
		HobbitConfigurationVO sut = new HobbitConfigurationVO(null, null, null);
		
		//assert
		assertNotNull(sut);
	}
	
	private HobbitConfigurationVO getHobbitConfigurationMock(HobbitUnitDefinitionVO definition) {
		HobbitConfigurationVO mock = EasyMock.createMock(HobbitConfigurationVO.class);
		EasyMock.expect(mock.getTier1FootUnit()).andReturn(definition);
		EasyMock.expect(mock.getTier1MountedUnit()).andReturn(definition);
		EasyMock.expect(mock.getTier1RangedUnit()).andReturn(definition);
		
        return mock;
	}
	/**
	 * Test to check if passed parameters to constructor are correctly assigned to properties
	 */
	public void testCanAssignUnitDefinitonViaConstructor() {
		//arrange
		HobbitUnitDefinitionVO definition = getHobbitUnitDefinition();
		
		//act
		HobbitConfigurationVO sut1 = getHobbitConfigurationMock(definition);
		
		//assert
		assertSame(definition, sut1.getTier1FootUnit());
		assertSame(definition, sut1.getTier1MountedUnit());
		assertSame(definition, sut1.getTier1RangedUnit());
	}
	
	/**
	 * TODO: switch to mocks
	 * @return
	 */
	private HobbitUnitDefinitionVO getHobbitUnitDefinition() {
		return new HobbitUnitDefinitionVO("test", 100, 100, 100, 100, 4, 1, UnitType.Foot);
	}
}
