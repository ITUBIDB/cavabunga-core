package tr.edu.itu.cavabunga.lib.entity.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
class ComponentTest {
	@ParameterizedTest
	@MethodSource("dataProviderNotValid")
	public void testValidateFail(Component testObject, Component parent, ArrayList<PropertyType> properties) throws Validation{
		testObject.setParent(parent);
		addMockProperties(testObject, properties);
		assertThrows(Validation.class, testObject::validate);
	}

	private static Stream dataProviderNotValid() {
		return Stream.of(
			Arguments.of(
				new Calendar(),
				new Event(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
					add(PropertyType.Version);
				}})
		);
	}

	@ParameterizedTest
	@MethodSource("dataProviderValid")
	public void testValidateSuccess(Component testObject, Component parent, ArrayList<PropertyType> properties) {
		testObject.setParent(parent);
		addMockProperties(testObject, properties);
		testObject.validate();
	}

	private static Stream dataProviderValid() {
		return Stream.of(
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
					add(PropertyType.Version);
				}})
		);
	}

	private void addMockProperties(Component testObject, ArrayList<PropertyType> properties) {
		for(PropertyType p : properties) {
			Property temp = mock(p.create().getClass());
			doNothing().when(temp).validate();
			when(temp.getName()).thenReturn(p.name());
			testObject.addProperty(temp);
		}
	}
}
