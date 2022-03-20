package ningenme.net.api.infrastructure.comicmeMysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.infrastructure.comicmeMysql.mapper.CreatorMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CreatorMysqlRepository {
    private final CreatorMysqlMapper creatorMysqlMapper;

    public Integer getCount() {
        return creatorMysqlMapper.selectCount();
    }

}
