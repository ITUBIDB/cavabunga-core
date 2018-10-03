package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.component.Event;
import tr.edu.itu.cavabunga.lib.entity.component.Journal;
import tr.edu.itu.cavabunga.lib.entity.component.Todo;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
public class Partstat extends Parameter {
	private static List<String> validEventValues = Arrays.asList(
		"NEEDS-ACTION",
		"ACCEPTED",
		"DECLINED",
		"TENTATIVE",
		"DELEGATED"
	);

	private static List<String> validTodoValues = Arrays.asList(
		"NEEDS-ACTION",
		"ACCEPTED",
		"DECLINED",
		"TENTATIVE",
		"DELEGATED",
		"COMPLETED",
		"IN-PROCESS"
	);

	private static List<String> validJournalValues = Arrays.asList(
		"NEEDS-ACTION",
		"ACCEPTED",
		"DECLINED"
	);

    @Override
    public void validate(){
        super.validate();

        if(this.getProperty().getComponent() instanceof Event){
            if(!validEventValues.contains(this.getValue())) {
                throw new Validation("PARTSTAT value is different from acceptable value range in an Event component: " + this.getValue());
            }
        }

        if(this.getProperty().getComponent() instanceof Todo){
            if(!validTodoValues.contains(this.getValue())) {
                throw new Validation("PARTSTAT value is different from acceptable value range in a Todo component: " + this.getValue());
            }
        }

        if(this.getProperty().getComponent() instanceof Journal){
			if(!validJournalValues.contains(this.getValue())) {
                throw new Validation("PARTSTAT value is different from acceptable value range in a Journal component " + this.getValue());
            }
        }
    }
}
