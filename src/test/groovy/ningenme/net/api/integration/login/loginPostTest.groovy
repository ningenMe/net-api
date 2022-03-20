package ningenme.net.api.integration.login

import ningenme.net.api.application.controller.netUser.postDto.NetUserPostRequest
import ningenme.net.api.common.config.db.NingenmeMysqlConfig
import ningenme.net.api.domain.entity.NetUser
import ningenme.net.api.domain.service.NetUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Ignore
import spock.lang.Specification

import javax.sql.DataSource
import java.sql.Connection
import java.sql.Statement

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@Ignore
class loginPostTest extends Specification {

    private final static API_PATH = "/v1/login"

    @Autowired
    MockMvc mockMvc;

    @Autowired
    NetUserService netUserService;

    @Autowired
    @Qualifier(NingenmeMysqlConfig.DATA_SOURCE)
    DataSource dataSource;

    def setup() {
        //ユーザを作成しておく
        NetUserPostRequest netUserPostRequest = new NetUserPostRequest();
        netUserPostRequest.setNetUserId("spock_test_user")
        netUserPostRequest.setPassword("passw0rD")
        netUserService.post(NetUser.of(netUserPostRequest))
    }

    def cleanup() {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.prepareStatement("TRUNCATE net_users")
        statement.execute()
    }

    def "[正常系] login passwordが適切 200が返る"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders
            .post(API_PATH)
            .param("email", "spock_test_user")
            .param("password", "passw0rD"))
            .andExpect(status().isOk())
            .andReturn()

        then:
        noExceptionThrown()
    }

    def "[正常系] login passwordが不適切 302が返る"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders
            .post(API_PATH)
            .param("email", "spock_test_user")
            .param("password", "hogeFuga0"))
            .andExpect(status().isFound())
            .andReturn()

        then:
        noExceptionThrown()
    }
}
