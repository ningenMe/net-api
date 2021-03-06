package ningenme.net.api.domain.value

import spock.lang.Specification
import spock.lang.Unroll

class EncryptedPasswordTest extends Specification {

    @Unroll
    def "[正常系] of value=#target EncryptedPasswordを返す"() {
        when:
        EncryptedPassword.of(target)
        then:
        noExceptionThrown()

        where:
        target                     || _
        RawPassword.of("aA0aA0aA") || _
        "hoge"                     || _
    }

    @Unroll
    def "[異常系] of string EncryptedPasswordを返す"() {
        when:
        EncryptedPassword.of((String)null)
        then:
        thrown(NullPointerException)
    }
    @Unroll
    def "[異常系] of RawPassword EncryptedPasswordを返す"() {
        when:
        EncryptedPassword.of((RawPassword)null)
        then:
        thrown(NullPointerException)
    }

}
