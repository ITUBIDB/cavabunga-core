package tr.edu.itu.cavabunga.lib.entity.property;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
class PropertyTest {

	@ParameterizedTest
	@MethodSource("validInputProvider")
	public void testValidateSuccess(Property property) {
		property.validate();
	}

	@ParameterizedTest
	@MethodSource("invalidInputProvider")
	public void testValidateFail(Property property) {
		assertThrows(Validation.class, property::validate);
	}

	private static Stream invalidInputProvider() {
		Property property = mock(Property.class);
		doThrow(Validation.class).when(property).validate();
		return Stream.of(
			Arguments.of(
				property
			)
		);
	}

	private static Stream validInputProvider() {
		Property property = mock(Property.class);
		doNothing().when(property).validate();
		return Stream.of(
			Arguments.of(
				property
			)
		);
	}
}
