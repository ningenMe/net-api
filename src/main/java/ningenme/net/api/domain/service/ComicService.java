package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Comic;
import ningenme.net.api.domain.value.Isbn13;
import ningenme.net.api.infrastructure.mysql.ComicMysqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComicService {

    private final ComicMysqlRepository comicMysqlRepository;

    public List<Comic> getComicByIsbn(@NonNull final List<Isbn13> isbn13List) {
        return comicMysqlRepository.get(isbn13List);
    }
}
