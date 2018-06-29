package tr.edu.itu.cavabunga.lib.factory;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.parameter.ParameterType;

/**
 * Factory interface for all parameter types
 * @see ParameterType
 * @see Parameter
 */
public interface ParameterFactory {

    /**
     * creates parameter in desired type
     *
     * @param parameterType type of the new parameter
     * @return created parameter object
     */
    Parameter createParameter(ParameterType parameterType);
}
