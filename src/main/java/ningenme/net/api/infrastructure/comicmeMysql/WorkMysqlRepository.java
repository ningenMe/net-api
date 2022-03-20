package ningenme.net.api.infrastructure.comicmeMysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.infrastructure.comicmeMysql.mapper.WorkMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class WorkMysqlRepository {
    private final WorkMysqlMapper workMysqlMapper;

    public Integer getCount() {
        return workMysqlMapper.selectCount();
    }

}
