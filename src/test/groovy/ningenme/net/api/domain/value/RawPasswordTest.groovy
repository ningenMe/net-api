package ningenme.net.api.domain.value

import spock.lang.Specification
import spock.lang.Unroll

class RawPasswordTest extends Specification {

    @Unroll
    def "[正常系] of value=#target RawPasswordを返す"() {
        when:
        RawPassword.of(target)
        then:
        noExceptionThrown()

        where:
        target     || _
        "aA0aA0aA" || _
        "aA0bbbbbbb111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999" || _
    }

    @Unroll
    def "[異常系] of value=#target RuntimeExceptionを返す"() {
        when:
        RawPassword.of(target)
        then:
        thrown(expect as Class<Throwable>)

        where:
        target       || expect
        null         || NullPointerException
        "password"   || IllegalArgumentException
        "aA0aA0a"    || IllegalArgumentException
        "aAaAaAaAaA" || IllegalArgumentException
        "A0A0A0A0A0" || IllegalArgumentException
        "a0a0a0a0a0" || IllegalArgumentException
        "aA0bbbbbbb1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990" || IllegalArgumentException
    }

}
