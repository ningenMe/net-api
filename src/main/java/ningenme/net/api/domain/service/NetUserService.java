package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.domain.value.NetUserId;
import ningenme.net.api.infrastructure.ningenmeMysql.NetUserMysqlRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class NetUserService implements UserDetailsService {
    private final NetUserMysqlRepository netUserMysqlRepository;

    public void post(@NonNull final NetUser netUser) {
        netUserMysqlRepository.post(netUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final NetUser netUser = netUserMysqlRepository.get(NetUserId.of(username));
        if (Objects.isNull(netUser)) {
            throw new UsernameNotFoundException(username + " is not found");
        }
        return netUser.getUser();
    }

    public NetUser getNetUser(@NonNull final NetUserId netUserId) {
        return netUserMysqlRepository.get(netUserId);
    }
}
