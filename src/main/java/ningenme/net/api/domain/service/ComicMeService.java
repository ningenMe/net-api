package ningenme.net.api.domain.service;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComicMeMeta;
import ningenme.net.api.infrastructure.mysql.ComicMysqlRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComicMeService {

    private final ComicMysqlRepository comicMysqlRepository;

    public ComicMeMeta getMeta() {
        return ComicMeMeta.builder()
                          .publisherCount(0)
                          .creatorCount(0)
                          .workCount(0)
                          .comicCount(comicMysqlRepository.getCount())
                          .build();
    }
}
