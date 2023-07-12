package mou.terminal.web.repository.mysql.auth;

import mou.terminal.web.domain.mysql.auth.UserRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRefreshTokenRepo extends JpaRepository<UserRefreshToken,Integer> {

    UserRefreshToken findByUserId(String userId);
    UserRefreshToken findByUserIdAndRefreshToken(String userId, String refreshToken);

}
