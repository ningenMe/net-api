package ningenme.net.api.domain.value

import spock.lang.Specification
import spock.lang.Unroll

class ApplicationMetaIdTest extends Specification {

  @Unroll
  def "[正常系] of valueが適切 ApplicationMetaIdを返す"() {
    when:
    def actual = ApplicationMetaId.of(target)
    then:
    noExceptionThrown()
    assert actual == expect
    assert actual.getValue() == target

    where:
    target    || expect
    "net-api" || ApplicationMetaId.NET_API
  }

  @Unroll
  def "[異常系] of valueが不適切 RuntimeExceptionを返す"() {
    when:
    ApplicationMetaId.of(target)
    then:
    thrown(RuntimeException)

    where:
    target    || _
    "net-ap " || _
    "hoge"    || _
    null      || _
  }

}