package tr.edu.itu.cavabunga.lib.factory;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.lib.entity.participant.*;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
class ParticipantFactoryImplTest {

    @ParameterizedTest
    @MethodSource("dataProviderParameterType")
    void testCreateParticipant(ParticipantType participantType, Class targetClass){
        ParticipantFactory participantFactory = new ParticipantFactoryImpl();
        Participant result = participantFactory.createParticipant(participantType);
        Assert.assertThat(result, instanceOf(targetClass));
    }

    private static Stream dataProviderParameterType() {
        return Stream.of(
            Arguments.of(ParticipantType.Group, Group.class),
            Arguments.of(ParticipantType.Resource, Resource.class),
            Arguments.of(ParticipantType.User, User.class)
        );
    }
}