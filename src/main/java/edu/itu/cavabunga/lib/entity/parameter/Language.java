package edu.itu.cavabunga.lib.entity.parameter;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.exception.Validation;
import org.apache.commons.lang.LocaleUtils;

import javax.persistence.Entity;

@Entity
public class Language extends Parameter {
    @Override
    public void validate(){
        super.validate();
        try {
            LocaleUtils.toLocale(this.getValue());
        }catch (IllegalArgumentException e){
            throw new Validation("Language parameter failed: " + e.getMessage());
        }
    }
}
