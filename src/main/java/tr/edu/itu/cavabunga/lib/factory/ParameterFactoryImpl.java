package tr.edu.itu.cavabunga.lib.factory;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.parameter.ParameterType;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component
public class ParameterFactoryImpl implements ParameterFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Parameter createParameter(ParameterType parameterType) {
        return parameterType.create();
    }
}