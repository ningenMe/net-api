package ningenme.net.api.domain.service;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComicMeMeta;
import ningenme.net.api.infrastructure.comicmeMysql.ComicMysqlRepository;
import ningenme.net.api.infrastructure.comicmeMysql.CreatorMysqlRepository;
import ningenme.net.api.infrastructure.comicmeMysql.PublisherMysqlRepository;
import ningenme.net.api.infrastructure.comicmeMysql.WorkMysqlRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComicMeService {

    private final ComicMysqlRepository comicMysqlRepository;
    private final WorkMysqlRepository workMysqlRepository;
    private final PublisherMysqlRepository publisherMysqlRepository;
    private final CreatorMysqlRepository creatorMysqlRepository;

    public ComicMeMeta getComicMeMeta() {
        return ComicMeMeta.builder()
            .publisherCount(publisherMysqlRepository.getCount())
            .creatorCount(creatorMysqlRepository.getCount())
            .workCount(workMysqlRepository.getCount())
            .comicCount(comicMysqlRepository.getCount())
            .build();
    }
}
