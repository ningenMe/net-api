package ningenme.net.api.domain.service;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComicMeMeta;
import ningenme.net.api.infrastructure.mysql.ComicMysqlRepository;
import ningenme.net.api.infrastructure.mysql.CreatorMysqlRepository;
import ningenme.net.api.infrastructure.mysql.PublisherMysqlRepository;
import ningenme.net.api.infrastructure.mysql.WorkMysqlRepository;
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
