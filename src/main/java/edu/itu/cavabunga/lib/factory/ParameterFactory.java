package edu.itu.cavabunga.lib.factory;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.entity.parameter.ParameterType;

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
