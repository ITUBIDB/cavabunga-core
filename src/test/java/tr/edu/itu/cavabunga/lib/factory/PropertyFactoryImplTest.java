package tr.edu.itu.cavabunga.lib.factory;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.entity.property.*;
import tr.edu.itu.cavabunga.lib.entity.property.Class;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
class PropertyFactoryImplTest {

    @ParameterizedTest
    @MethodSource("dataProviderPropertyType")
	void testCreateProperty(PropertyType propertyType, java.lang.Class targetClass){
        PropertyFactory propertyFactory = new PropertyFactoryImpl();
        Property result = propertyFactory.createProperty(propertyType);
        Assert.assertThat(result, instanceOf(targetClass));
    }

    private static Stream dataProviderPropertyType(){
        return Stream.of(
            Arguments.of(PropertyType.Acknowledged, Acknowledged.class),
            Arguments.of(PropertyType.Action, Action.class),
            Arguments.of(PropertyType.Attach, Attach.class),
            Arguments.of(PropertyType.Attendee, Attendee.class),
            Arguments.of(PropertyType.Calscale, Calscale.class),
            Arguments.of(PropertyType.Catagories, Catagories.class),
            Arguments.of(PropertyType.Class, Class.class),
            Arguments.of(PropertyType.Comment, Comment.class),
            Arguments.of(PropertyType.Completed, Completed.class),
            Arguments.of(PropertyType.Contact, Contact.class),
            Arguments.of(PropertyType.Country, Country.class),
            Arguments.of(PropertyType.Created, Created.class),
            Arguments.of(PropertyType.Description, Description.class),
            Arguments.of(PropertyType.Dtend, Dtend.class),
            Arguments.of(PropertyType.Dtstamp, Dtstamp.class),
            Arguments.of(PropertyType.Dtstart, Dtstart.class),
            Arguments.of(PropertyType.Due, Due.class),
            Arguments.of(PropertyType.Duration, Duration.class),
            Arguments.of(PropertyType.Exdate, Exdate.class),
            Arguments.of(PropertyType.Exrule, Exrule.class),
            Arguments.of(PropertyType.Freebusy, Freebusy.class),
            Arguments.of(PropertyType.Geo, Geo.class),
            Arguments.of(PropertyType.Lastmod, Lastmod.class),
            Arguments.of(PropertyType.Location, Location.class),
            Arguments.of(PropertyType.Method, Method.class),
            Arguments.of(PropertyType.Organizer, Organizer.class),
            Arguments.of(PropertyType.Percent, Percent.class),
            Arguments.of(PropertyType.Priority, Priority.class),
            Arguments.of(PropertyType.Prodid, Prodid.class),
            Arguments.of(PropertyType.Rdate, Rdate.class),
            Arguments.of(PropertyType.Recurid, Recurid.class),
            Arguments.of(PropertyType.Related, Related.class),
            Arguments.of(PropertyType.Repeat, Repeat.class),
            Arguments.of(PropertyType.Resources, Resources.class),
            Arguments.of(PropertyType.Rrule, Rrule.class),
            Arguments.of(PropertyType.Rstatus, Rstatus.class),
            Arguments.of(PropertyType.Seq, Seq.class),
            Arguments.of(PropertyType.Status, Status.class),
            Arguments.of(PropertyType.Summary, Summary.class),
            Arguments.of(PropertyType.Transp, Transp.class),
            Arguments.of(PropertyType.Trigger, Trigger.class),
            Arguments.of(PropertyType.Tzid, Tzid.class),
            Arguments.of(PropertyType.Tzname, Tzname.class),
            Arguments.of(PropertyType.Tzoffsetfrom, Tzoffsetfrom.class),
            Arguments.of(PropertyType.Tzoffsetto, Tzoffsetto.class),
            Arguments.of(PropertyType.Tzurl, Tzurl.class),
            Arguments.of(PropertyType.Uid, Uid.class),
            Arguments.of(PropertyType.Url, Url.class),
            Arguments.of(PropertyType.Version, Version.class)
        );
    }
}