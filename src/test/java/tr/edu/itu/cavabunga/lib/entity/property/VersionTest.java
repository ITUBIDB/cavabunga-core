package tr.edu.itu.cavabunga.lib.entity.property;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

@RunWith(JUnitPlatform.class)
class VersionTest extends PropertyTest {

	private static Stream invalidInputProvider() {
		Version version1 = new Version();
		version1.setValue("1.0");
		Version version2 = new Version();
		version2.setValue("1.9");
		return Stream.of(
			Arguments.of(
				version1
			),
			Arguments.of(
				version2
			)
		);
	}

	private static Stream validInputProvider() {
		Version version = new Version();
		version.setValue("2.0");
		return Stream.of(
			Arguments.of(
				version
			)
		);
	}
}
