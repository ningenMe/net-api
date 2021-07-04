package ningenme.net.api.domain.value

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime

class CreatedTimeTest extends Specification {

    @Unroll
    def "[正常系] toString value=#target 適切なstringを返す"() {
        when:
        def actual = CreatedTime.of(LocalDateTime.parse(target)).toString()
        then:
        noExceptionThrown()
        assert actual == expect

        where:
        target                || expect
        "2021-01-02T03:40:50" || "2021-01-02T03:40:50"
    }

}
