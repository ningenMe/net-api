package ningenme.net.api.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"ningenme.net.api.infrastructure.mysql.mapper"})
public class NingenmeMysqlConfig {

    public static final String DATA_SOURCE = "ningenmeMysqlDataSource";
    private static final String DATA_SOURCE_PROPERTIES = "ningenmeMysqlDataSourceProperties";
    private static final String DATA_SOURCE_TRANSACTION_MANAGER = "ningenmeMysqlTransactionManager";
    private static final String SQL_SESSION_FACTORY = "ningenmeMysqlSqlSessionFactory";

    @Bean(name = DATA_SOURCE_PROPERTIES)
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.ningenme-mysql")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = DATA_SOURCE)
    public DataSource dataSource(@Qualifier(DATA_SOURCE_PROPERTIES) DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = DATA_SOURCE_TRANSACTION_MANAGER)
    public DataSourceTransactionManager dataSourceTransactionManager(
        @Qualifier(DATA_SOURCE) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(
        @Qualifier(DATA_SOURCE) DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        {
            org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setMapUnderscoreToCamelCase(true);
            sqlSessionFactoryBean.setConfiguration(configuration);
        }

        return sqlSessionFactoryBean.getObject();
    }
}
