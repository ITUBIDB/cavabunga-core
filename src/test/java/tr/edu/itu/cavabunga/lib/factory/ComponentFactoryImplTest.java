package tr.edu.itu.cavabunga.lib.factory;


import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.component.*;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
class ComponentFactoryImplTest {

    @ParameterizedTest
    @MethodSource("dataProviderComponentType")
    void testCreateParameter(ComponentType componentType, Class targetClass){
		ComponentFactory componentFactory = new ComponentFactoryImpl();
        Component result = componentFactory.createComponent(componentType);
        Assert.assertThat(result, instanceOf(targetClass));
    }

    private static Stream dataProviderComponentType() {
        return Stream.of(
            Arguments.of(ComponentType.Alarm, Alarm.class),
            Arguments.of(ComponentType.Calendar, Calendar.class),
            Arguments.of(ComponentType.Daylight, Daylight.class),
            Arguments.of(ComponentType.Event, Event.class),
            Arguments.of(ComponentType.Freebusy, Freebusy.class),
            Arguments.of(ComponentType.Journal, Journal.class),
            Arguments.of(ComponentType.Standard, Standard.class),
            Arguments.of(ComponentType.Timezone, Timezone.class),
            Arguments.of(ComponentType.Todo, Todo.class)
        );
    }
}