package ningenme.net.api.infrastructure.mysql

import ningenme.net.api.common.config.NingenmeMysqlConfig
import ningenme.net.api.domain.value.ApplicationMetaId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import javax.sql.DataSource
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

@SpringBootTest
@Ignore
class ApplicationMetaMysqlRepositoryTest extends Specification {

    @Autowired
    ApplicationMetaMysqlRepository applicationMetaMysqlRepository;

    @Autowired
    @Qualifier(NingenmeMysqlConfig.DATA_SOURCE)
    DataSource dataSource;

    Connection connection;

    def setup() {
        connection = dataSource.getConnection()
    }

    @Unroll
    def "[正常系] getLatestOne applicationMetaId = #target 適切なレスポンスが返る"() {
        setup:
        Statement statement = connection.prepareStatement("INSERT INTO application_metas (application_meta_id) VALUES ('" + target + "')")
        statement.execute()

        when:
        def actual = applicationMetaMysqlRepository.getLatestOne(ApplicationMetaId.of(target));

        then:
        noExceptionThrown()
        assert actual.getApplicationMetaId().getValue() == expect

        where:
        target      | expect
        "net-api"   | "net-api"
        "net-front" | "net-front"
    }

    @Unroll
    def "[異常系] getLatestOne #target nullPointerExceptionが返る"() {
        setup:
        Statement statement = connection.prepareStatement("INSERT INTO application_metas (application_meta_id) VALUES ('hoge')")
        statement.execute()
        when:
        applicationMetaMysqlRepository.getLatestOne();
        then:
        thrown(NullPointerException)
        where:
        target                    || _
        ApplicationMetaId.NET_API || _
        null                      || _
    }

    @Unroll
    def "[正常系] get applicationMetaId = #target 適切なレスポンスが返る"() {
        setup:
        Statement statement1 = connection.prepareStatement("INSERT INTO application_metas (application_meta_id, created_time) VALUES ('" + dbtarget + "', '2020-01-01 00:00:00')")
        statement1.execute()
        Statement statement2 = connection.prepareStatement("INSERT INTO application_metas (application_meta_id, created_time) VALUES ('" + dbtarget + "', '2020-01-02 00:00:00')")
        statement2.execute()
        when:
        def actual = applicationMetaMysqlRepository.get(ApplicationMetaId.of(target));
        then:
        noExceptionThrown()
        assert actual.size() == expect
        where:
        dbtarget    | target      | expect
        "net-api"   | "net-api"   | 2
        "net-front" | "net-front" | 2
        "hoge"      | "net-api"   | 0
    }

    @Unroll
    def "[異常系] get #target nullPointerExceptionが返る"() {
        setup:
        Statement statement1 = connection.prepareStatement("INSERT INTO application_metas (application_meta_id) VALUES ('" + target + "')")
        statement1.execute()
        when:
        applicationMetaMysqlRepository.get();
        then:
        thrown(NullPointerException)
        where:
        target || _
        null   || _
    }

    @Unroll
    def "[正常系] post 適切なinsertができている"() {
        when:
        applicationMetaMysqlRepository.post(ApplicationMetaId.of("net-api"));
        Statement statement = connection.prepareStatement("SELECT * FROM application_metas")
        ResultSet resultSet = statement.executeQuery()
        resultSet.next()
        then:
        def actual = resultSet.getString("application_meta_id")
        noExceptionThrown()
        assert actual == "net-api"
    }

    @Unroll
    def "[異常系] post #target nullPointerExceptionが返る"() {
        when:
        applicationMetaMysqlRepository.post(null);
        then:
        thrown(NullPointerException)
    }

    def cleanup() {
        Statement statement = connection.prepareStatement(
            "TRUNCATE application_metas"
        )
        statement.execute()
        connection.close()
    }

}
