package ningenme.net.api.infrastructure.ningenmeMysql

import ningenme.net.api.domain.entity.Blog
import ningenme.net.api.domain.value.*
import org.dbunit.database.DatabaseConfig
import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.filter.DefaultColumnFilter
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder
import org.dbunit.ext.mysql.MySqlMetadataHandler
import org.dbunit.operation.DatabaseOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.dbunit.Assertion.assertEquals

@SpringBootTest
@Ignore
class BlogMysqlRepositoryTest extends Specification {

    private final static String FILE_PATH = "src/test/groovy/ningenme/net/api/infrastructure/mysql/blogs"

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BlogMysqlRepository blogMysqlRepository;

    IDatabaseConnection iDatabaseConnection

    def setup() {
        iDatabaseConnection = new DatabaseConnection(jdbcTemplate.getDataSource().getConnection(), "ningenme", false);
        iDatabaseConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
    }

    @Shared
    def blog1 = Blog.builder()
        .blogType(BlogType.DIARY)
        .blogTitle(BlogTitle.of("blog1"))
        .url(Url.of("http://localhost:8080/blog1"))
        .liked(Liked.of(0))
        .postedDate(PostedDate.of("2021-01-01"))
        .build()
    @Shared
    def blog2 = Blog.builder()
        .blogType(BlogType.DIARY)
        .blogTitle(BlogTitle.of("blog2"))
        .url(Url.of("http://localhost:8080/blog2"))
        .liked(Liked.of(0))
        .postedDate(PostedDate.of("2021-02-01"))
        .build()
    @Shared
    def blog3 = Blog.builder()
        .blogType(BlogType.DIARY)
        .blogTitle(BlogTitle.of("blog3"))
        .url(Url.of("http://localhost:8080/blog3"))
        .liked(Liked.of(0))
        .postedDate(PostedDate.of("2021-03-01"))
        .build()
    @Shared
    def blog4 = Blog.builder()
        .blogType(BlogType.AMEBA)
        .blogTitle(BlogTitle.of("blog4"))
        .url(Url.of("https://ameblo.jp/ningenme/entry-12323588612.html"))
        .liked(Liked.of(20))
        .postedDate(PostedDate.of("2017-10-23"))
        .build()
    @Shared
    def blog5 = Blog.builder()
        .blogType(BlogType.HATENA)
        .blogTitle(BlogTitle.of("??????????????????????????????????????? 1???????????????"))
        .url(Url.of("https://ameblo.jp/ningenme/entry-12323588612.html"))
        .liked(Liked.of(0))
        .postedDate(PostedDate.of("2021-10-10"))
        .build()

    @Unroll
    def "[?????????] post #purpose"() {
        setup:
        DatabaseOperation.CLEAN_INSERT.execute(
            iDatabaseConnection,
            new FlatXmlDataSetBuilder().build(new File(FILE_PATH + "/table-setup.xml"))
        )

        when:
        blogMysqlRepository.post(blogs);

        then:
        def actual = DefaultColumnFilter.excludedColumnsTable(
            iDatabaseConnection.createDataSet().getTable("blogs"),
            new String[]{"deleted_time", "created_time", "updated_time"}
        )

        def expect = DefaultColumnFilter.excludedColumnsTable(
            new FlatXmlDataSetBuilder().build(new File(FILE_PATH + expectXml)).getTable("blogs"),
            new String[]{"deleted_time", "created_time", "updated_time"}
        )

        assertEquals(expect, actual)
        noExceptionThrown()

        where:
        blogs                 | expectXml                      | purpose
        [blog1]               | "/table-expect-new-one.xml"    | "?????????????????????"
        [blog1, blog2, blog3] | "/table-expect-new-multi.xml"  | "?????????????????????"
        []                    | "/table-expect-empty.xml"      | "???????????????"
        [blog4]               | "/table-expect-update.xml"     | "??????????????????????????????????????????"
        [blog5]               | "/table-expect-non-update.xml" | "title????????????????????????"
    }

    @Unroll
    def "[?????????] put #purpose"() {
        setup:
        DatabaseOperation.CLEAN_INSERT.execute(
            iDatabaseConnection,
            new FlatXmlDataSetBuilder().build(new File(FILE_PATH + "/table-setup.xml"))
        )

        when:
        blogMysqlRepository.put(blogs);

        then:
        def actual = DefaultColumnFilter.excludedColumnsTable(
            iDatabaseConnection.createDataSet().getTable("blogs"),
            new String[]{"deleted_time", "created_time", "updated_time"}
        )

        def expect = DefaultColumnFilter.excludedColumnsTable(
            new FlatXmlDataSetBuilder().build(new File(FILE_PATH + expectXml)).getTable("blogs"),
            new String[]{"deleted_time", "created_time", "updated_time"}
        )

        assertEquals(expect, actual)
        noExceptionThrown()

        where:
        blogs                 | expectXml                       | purpose
        [blog1]               | "/table-expect-new-one.xml"     | "?????????????????????"
        [blog1, blog2, blog3] | "/table-expect-new-multi.xml"   | "?????????????????????"
        []                    | "/table-expect-empty.xml"       | "???????????????"
        [blog4]               | "/table-expect-like-update.xml" | "??????????????????????????????????????????"
    }

}
