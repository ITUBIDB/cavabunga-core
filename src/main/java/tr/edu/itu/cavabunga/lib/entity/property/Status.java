package tr.edu.itu.cavabunga.lib.entity.property;

import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.entity.component.Event;
import tr.edu.itu.cavabunga.lib.entity.component.Journal;
import tr.edu.itu.cavabunga.lib.entity.component.Todo;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
public class Status extends Property {
	private static List<String> validEventValues = Arrays.asList(
		"TENTATIVE",
		"CONFIRMED",
		"CANCELLED"
	);

	private static List<String> validTodoValues = Arrays.asList(
		"NEEDS-ACTION",
		"COMPLETED",
		"IN-PROCESS",
		"CANCELLED"
	);

	private static List<String> validJournalValues = Arrays.asList(
		"DRAFT",
		"FINAL",
		"CANCELLED"
	);

	@Override
	public void validate(){
		super.validate();

		if(this.getComponent() instanceof Event){
			if(!validEventValues.contains(this.getValue())) {
				throw new Validation("STATUS value is different from acceptable value range in an Event component: " + this.getValue());
			}
		}

		if(this.getComponent() instanceof Todo){
			if(!validTodoValues.contains(this.getValue())) {
				throw new Validation("STATUS value is different from acceptable value range in a Todo component: " + this.getValue());
			}
		}

		if(this.getComponent() instanceof Journal){
			if(!validJournalValues.contains(this.getValue())) {
				throw new Validation("STATUS value is different from acceptable value range in a Journal component " + this.getValue());
			}
		}
	}
}
