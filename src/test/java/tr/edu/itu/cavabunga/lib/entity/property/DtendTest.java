package tr.edu.itu.cavabunga.lib.entity.property;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import java.util.stream.Stream;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
class DtendTest extends PropertyTest {

	private static Stream invalidInputProvider() {
		// TODO: 10/2/2018 test with non-mock object
		Dtend dtend1 = mock(Dtend.class);
		doThrow(Validation.class).when(dtend1).validate();
		return Stream.of(
			Arguments.of(
				dtend1
			)
		);
	}

	private static Stream validInputProvider() {
		Dtend dtend1 = new Dtend();
		dtend1.setValue("20100212T235900");
		return Stream.of(
			Arguments.of(
				dtend1
			)
		);
	}
}
