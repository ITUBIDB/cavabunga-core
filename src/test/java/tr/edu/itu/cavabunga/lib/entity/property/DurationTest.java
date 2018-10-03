package tr.edu.itu.cavabunga.lib.entity.property;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import java.util.stream.Stream;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
class DurationTest extends PropertyTest {

	private static Stream invalidInputProvider() {
		// TODO: 10/2/2018 test with non-mock object
		Duration duration1 = mock(Duration.class);
		doThrow(Validation.class).when(duration1).validate();
		return Stream.of(
			Arguments.of(
				duration1
			)
		);
	}

	private static Stream validInputProvider() {
		Duration duration1 = new Duration();
		duration1.setValue("P15DT5H0M20S");
		return Stream.of(
			Arguments.of(
				duration1
			)
		);
	}
}
