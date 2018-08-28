package tr.edu.itu.cavabunga.lib.entity.component;

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
class AlarmTest {
	@ParameterizedTest
	@MethodSource("dataProviderNotValid")
	void validateFailTest(Component parent, ArrayList<PropertyType> properties) throws Validation{
		Alarm alarm = new Alarm();
		alarm.setParent(parent);
		for(PropertyType p : properties) {
			Property temp = p.create();
			temp.setName(p.name());
			alarm.addProperty(temp);
		}
		assertThrows(Validation.class, alarm::validate);
	}

	private static Stream dataProviderNotValid() {
		return Stream.of(
			Arguments.of(
				new Freebusy(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Due);
					add(PropertyType.Repeat);
				}}),
			Arguments.of(
				new Event(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Due);
					add(PropertyType.Due);
				}})
		);
	}

	@ParameterizedTest
	@MethodSource("dataProviderValid")
	void validateSuccessTest(Component parent, ArrayList<PropertyType> properties){
		Alarm alarm = new Alarm();
		alarm.setParent(parent);
		for(PropertyType p : properties) {
			Property temp = mock(p.create().getClass());
			doNothing().when(temp).validate();
			when(temp.getName()).thenReturn(p.name());
			alarm.addProperty(temp);
		}
		alarm.validate();
	}

	private static Stream dataProviderValid() {
		return Stream.of(
			Arguments.of(
				new Event(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Action);
					add(PropertyType.Trigger);
				}}),
			Arguments.of(
				new Todo(),
				new ArrayList<PropertyType>() {{
					add(PropertyType.Action);
					add(PropertyType.Trigger);
					add(PropertyType.Due);
				}})
		);
	}
}
