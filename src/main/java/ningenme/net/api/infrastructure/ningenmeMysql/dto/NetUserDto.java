package ningenme.net.api.infrastructure.ningenmeMysql.dto;

import lombok.Data;

@Data
public class NetUserDto {
    private String netUserId;
    private String role;
    private String password;
}
