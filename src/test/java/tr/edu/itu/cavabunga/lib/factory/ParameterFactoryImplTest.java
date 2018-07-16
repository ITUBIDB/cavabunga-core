package tr.edu.itu.cavabunga.lib.factory;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.parameter.*;

import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(DataProviderRunner.class)
@SpringBootTest
public class ParameterFactoryImplTest {
    public ParameterFactory parameterFactory;

    @Before
    public void setup(){
        parameterFactory = new ParameterFactoryImpl();
    }

    @Test
    @UseDataProvider("dataProviderParameterType")
    public void testCreateParameter(ParameterType parameterType, Class targetClass){
        Parameter result = parameterFactory.createParameter(parameterType);
        Assert.assertThat(result, instanceOf(targetClass));
    }

    @DataProvider
    public static Object[][] dataProviderParameterType() {
        return new Object[][] {
                {ParameterType.Altrep, Altrep.class},
                {ParameterType.Cn, Cn.class},
                {ParameterType.Cutype, Cutype.class},
                {ParameterType.DelegatedFrom, DelegatedFrom.class},
                {ParameterType.DelegatedTo, DelegatedTo.class},
                {ParameterType.Dir, Dir.class},
                {ParameterType.Encoding, Encoding.class},
                {ParameterType.Fbtype, Fbtype.class},
                {ParameterType.Language, Language.class},
                {ParameterType.Member, Member.class},
                {ParameterType.Partstat, Partstat.class},
                {ParameterType.Range, Range.class},
                {ParameterType.Related, Related.class},
                {ParameterType.Reltype, Reltype.class},
                {ParameterType.Role, Role.class},
                {ParameterType.Rsvp, Rsvp.class},
                {ParameterType.SentBy, SentBy.class},
                {ParameterType.Tzid, Tzid.class},
                {ParameterType.Value, Value.class},
        };
    }
}