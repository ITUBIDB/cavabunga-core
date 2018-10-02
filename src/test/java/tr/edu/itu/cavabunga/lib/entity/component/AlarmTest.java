package tr.edu.itu.cavabunga.lib.entity.component;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import java.util.ArrayList;
import java.util.stream.Stream;

@RunWith(JUnitPlatform.class)
class AlarmTest extends ComponentTest {

	private static Stream dataProviderNotValid() {
		return Stream.of(
			Arguments.of(
				new Alarm(),
				new Freebusy(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Due);
					add(PropertyType.Repeat);
				}}),
			Arguments.of(
				new Alarm(),
				new Event(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Due);
					add(PropertyType.Due);
				}})
		);
	}

	private static Stream dataProviderValid() {
		return Stream.of(
			Arguments.of(
				new Alarm(),
				new Event(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Action);
					add(PropertyType.Trigger);
				}}),
			Arguments.of(
				new Alarm(),
				new Todo(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Action);
					add(PropertyType.Trigger);
					add(PropertyType.Due);
				}})
		);
	}
}
