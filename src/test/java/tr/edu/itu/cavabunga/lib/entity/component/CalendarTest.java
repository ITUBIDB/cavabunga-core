package tr.edu.itu.cavabunga.lib.entity.component;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;

import java.util.ArrayList;
import java.util.stream.Stream;



@RunWith(JUnitPlatform.class)
class CalendarTest extends ComponentTest {

	private static Stream dataProviderNotValid() {
		return Stream.of(
			Arguments.of(
				new Calendar(),
				new Event(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
					add(PropertyType.Version);
				}}),
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
				}}),
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Version);
				}}),
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Version);
				}}),
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
					add(PropertyType.Version);
					add(PropertyType.Calscale);
					add(PropertyType.Calscale);
				}})
		);
	}


	private static Stream dataProviderValid() {
		return Stream.of(
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
					add(PropertyType.Version);
				}}),
			Arguments.of(
				new Calendar(),
				null,
				new ArrayList<PropertyType>() {{
					add(PropertyType.Prodid);
					add(PropertyType.Version);
				}})
		);
	}
}
