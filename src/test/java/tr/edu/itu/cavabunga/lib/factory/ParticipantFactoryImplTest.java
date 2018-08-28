package tr.edu.itu.cavabunga.lib.factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.lib.entity.participant.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnitPlatform.class)
class ParticipantFactoryImplTest {

	@ParameterizedTest
	@MethodSource("dataProviderParameterType")
	void testCreateParticipant(ParticipantType participantType, Class targetClass){
		ParticipantFactory participantFactory = new ParticipantFactoryImpl();
		Participant result = participantFactory.createParticipant(participantType);
		assertEquals(result.getClass().getName(), targetClass.getName());
	}

	private static Stream dataProviderParameterType() {
		return Stream.of(
			Arguments.of(ParticipantType.Group, Group.class),
			Arguments.of(ParticipantType.Resource, Resource.class),
			Arguments.of(ParticipantType.User, User.class)
		);
	}
}