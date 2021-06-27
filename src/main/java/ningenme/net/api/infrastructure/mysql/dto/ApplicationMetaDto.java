package ningenme.net.api.infrastructure.mysql.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationMetaDto {
  private String applicationMetaId;
  private LocalDateTime createdTime;
}
