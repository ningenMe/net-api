package ningenme.net.api.infrastructure.ningenmeMysql.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationMetaDto {
    private String applicationMetaId;
    private LocalDateTime createdTime;
}
