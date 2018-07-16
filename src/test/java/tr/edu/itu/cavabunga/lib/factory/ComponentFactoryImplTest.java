package tr.edu.itu.cavabunga.lib.factory;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.component.*;

import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(DataProviderRunner.class)
@SpringBootTest
public class ComponentFactoryImplTest {
    public ComponentFactory componentFactory;

    @Before
    public void setup(){
        componentFactory = new ComponentFactoryImpl();
    }

    @Test
    @UseDataProvider("dataProviderComponentType")
    public void testCreateParameter(ComponentType componentType, Class targetClass){
        Component result = componentFactory.createComponent(componentType);
        Assert.assertThat(result, instanceOf(targetClass));
    }


    @DataProvider
    public static Object[][] dataProviderComponentType() {
        return new Object[][] {
                {ComponentType.Alarm, Alarm.class},
                {ComponentType.Calendar, Calendar.class},
                {ComponentType.Daylight, Daylight.class},
                {ComponentType.Event, Event.class},
                {ComponentType.Freebusy, Freebusy.class},
                {ComponentType.Journal, Journal.class},
                {ComponentType.Standard, Standard.class},
                {ComponentType.Timezone, Timezone.class},
                {ComponentType.Todo, Todo.class},
        };
    }
}