package tr.edu.itu.cavabunga.lib.factory;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.lib.entity.participant.*;

import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(DataProviderRunner.class)
@SpringBootTest
public class ParticipantFactoryImplTest {
    public ParticipantFactory participantFactory;

    @Before
    public void setup(){
        participantFactory = new ParticipantFactoryImpl();
    }

    @Test
    @UseDataProvider("dataProviderParticipantType")
    public void testCreateParticipant(ParticipantType participantType, Class targetClass){
        Participant result = participantFactory.createParticipant(participantType);
        Assert.assertThat(result, instanceOf(targetClass));
    }

    @DataProvider
    public static Object[][] dataProviderParticipantType() {
        return new Object[][] {
                {ParticipantType.Group, Group.class},
                {ParticipantType.Resource, Resource.class},
                {ParticipantType.User, User.class},
        };
    }
}
