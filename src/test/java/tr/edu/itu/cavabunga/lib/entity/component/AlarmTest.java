package tr.edu.itu.cavabunga.lib.entity.component;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.entity.property.Action;
import tr.edu.itu.cavabunga.lib.entity.property.Trigger;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AlarmTest {
    private Alarm alarm;

    @Before
    public void setUp() {
        this.alarm = new Alarm();
        Event parentEvent = mock(Event.class);
        alarm.setParent(parentEvent);
        Action childAction = mock(Action.class);
        when(childAction.getClass()).thenReturn(Action.class);
        alarm.addProperty(childAction);
        Trigger childTrigger = mock(Trigger.class);
        alarm.addProperty(childTrigger);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void validateTest() {
        for(Property p : alarm.getProperties()){
            System.out.println(p.getClass());
        }
        alarm.validate();
    }
}
