package tr.edu.itu.cavabunga.lib.factory;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.parameter.*;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
class ParameterFactoryImplTest {
    @ParameterizedTest
    @MethodSource("dataProviderParameterType")
    void testCreateParameter(ParameterType parameterType, Class targetClass){
        ParameterFactory parameterFactory = new ParameterFactoryImpl();
        Parameter result = parameterFactory.createParameter(parameterType);
        Assert.assertThat(result, instanceOf(targetClass));
    }

    private static Stream dataProviderParameterType() {
        return Stream.of(
            Arguments.of(ParameterType.Altrep, Altrep.class),
            Arguments.of(ParameterType.Cn, Cn.class),
            Arguments.of(ParameterType.Cutype, Cutype.class),
            Arguments.of(ParameterType.DelegatedFrom, DelegatedFrom.class),
            Arguments.of(ParameterType.DelegatedTo, DelegatedTo.class),
            Arguments.of(ParameterType.Dir, Dir.class),
            Arguments.of(ParameterType.Encoding, Encoding.class),
            Arguments.of(ParameterType.Fbtype, Fbtype.class),
            Arguments.of(ParameterType.Language, Language.class),
            Arguments.of(ParameterType.Member, Member.class),
            Arguments.of(ParameterType.Partstat, Partstat.class),
            Arguments.of(ParameterType.Range, Range.class),
            Arguments.of(ParameterType.Related, Related.class),
            Arguments.of(ParameterType.Reltype, Reltype.class),
            Arguments.of(ParameterType.Role, Role.class),
            Arguments.of(ParameterType.Rsvp, Rsvp.class),
            Arguments.of(ParameterType.SentBy, SentBy.class),
            Arguments.of(ParameterType.Tzid, Tzid.class),
            Arguments.of(ParameterType.Value, Value.class)
        );
    }


}