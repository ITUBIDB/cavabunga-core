package tr.edu.itu.cavabunga.lib.entity.component;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;

import java.util.ArrayList;
import java.util.stream.Stream;

@RunWith(JUnitPlatform.class)
class EventTest extends ComponentTest {

	private static Stream dataProviderNotValid() {
		return Stream.of(
			Arguments.of(
				new Event(),
				new Freebusy(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Location);
				}}),
			Arguments.of(
				new Event(),
				new Calendar(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Status);
					add(PropertyType.Status);
				}}),
			Arguments.of(
				new Event(),
				new Calendar(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Duration);
				}}),
			Arguments.of(
				new Event(),
				new Calendar(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Dtend);
				}})
		);
	}

	private static Stream dataProviderValid() {
		return Stream.of(
			Arguments.of(
				new Event(),
				new Calendar(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Dtend);
					add(PropertyType.Duration);
				}}),
			Arguments.of(
				new Event(),
				new Calendar(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Dtend);
					add(PropertyType.Duration);
					add(PropertyType.Trigger);
					add(PropertyType.Due);
				}})
		);
	}
}
