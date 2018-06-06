package edu.itu.cavabunga.lib.factory;

import edu.itu.cavabunga.lib.entity.Participant;
import edu.itu.cavabunga.lib.entity.participant.ParticipantType;
import org.springframework.stereotype.Component;

/**
 * Factory for all participant types
 * @see ParticipantType
 * @see Participant
 */
@Component
public class ParticipantFactoryImpl implements ParticipantFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Participant createParticipant(ParticipantType participantType){
        return participantType.create();
    }
}
