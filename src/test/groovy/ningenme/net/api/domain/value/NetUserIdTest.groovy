package ningenme.net.api.domain.value

import spock.lang.Specification
import spock.lang.Unroll

class NetUserIdTest extends Specification {

    @Unroll
    def "[正常系] of value=#target NetUserIdを返す"() {
        when:
        NetUserId.of(target)
        then:
        noExceptionThrown()

        where:
        target      || _
        "hoge_user" || _
        "01234567890123456789" || _
    }

    @Unroll
    def "[異常系] of value=#target RuntimeExceptionを返す"() {
        when:
        NetUserId.of(target)
        then:
        thrown(expect as Class<Throwable>)

        where:
        target                  || expect
        (String)null            || NullPointerException
        "012345678901234567890" || IllegalArgumentException
        "Hoge_user"             || IllegalArgumentException
        "hoge-user"             || IllegalArgumentException
    }

}
