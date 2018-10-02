package tr.edu.itu.cavabunga.lib.entity.property;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.exception.Validation;
import java.util.stream.Stream;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
class ProdidTest extends PropertyTest {

	private static Stream invalidInputProvider() {
		// TODO: 10/2/2018 test with non-mock object
		Prodid prodid = mock(Prodid.class);
		doThrow(Validation.class).when(prodid).validate();
		return Stream.of(
			Arguments.of(
				prodid
			)
		);
	}

	private static Stream validInputProvider() {
		Prodid prodid1 = new Prodid();
		prodid1.setValue("-//davical.org//NONSGML AWL Calendar//EN");
		Prodid prodid2 = new Prodid();
		prodid2.setValue("-//Apple Inc.//iCal 4.0.4//EN");
		return Stream.of(
			Arguments.of(
				prodid1
			),
			Arguments.of(
				prodid2
			)
		);
	}
}
