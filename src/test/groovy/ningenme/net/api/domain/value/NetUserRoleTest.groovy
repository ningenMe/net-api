package ningenme.net.api.domain.value

import spock.lang.Specification
import spock.lang.Unroll

class NetUserRoleTest extends Specification {

    @Unroll
    def "[正常系] of value=#target NetUserRoleを返す"() {
        when:
        def actual = NetUserRole.of(target)
        then:
        noExceptionThrown()
        assert actual == expect
        assert actual.getValue() == target

        where:
        target  || expect
        "ADMIN" || NetUserRole.ADMIN
        "USER"  || NetUserRole.USER
    }

    @Unroll
    def "[異常系] of value=#target NetUserRoleを返す"() {
        when:
        NetUserRole.of(target)
        then:
        thrown(expect)

        where:
        target    || expect
        "admin"   || RuntimeException
        "hoge"    || RuntimeException
        null      || RuntimeException
    }

}
