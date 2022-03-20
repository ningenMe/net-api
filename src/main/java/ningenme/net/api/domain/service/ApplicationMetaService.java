package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.infrastructure.ningenmeMysql.ApplicationMetaMysqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationMetaService {

    private final ApplicationMetaMysqlRepository applicationMetaMysqlRepository;

    public List<ApplicationMeta> get(@NonNull final ApplicationMetaId applicationMetaId) {
        return applicationMetaMysqlRepository.get(applicationMetaId);
    }

    public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
        return applicationMetaMysqlRepository.getLatestOne(applicationMetaId);
    }

    public void post(@NonNull ApplicationMetaId applicationMetaId) {
        applicationMetaMysqlRepository.post(applicationMetaId);
    }
}
