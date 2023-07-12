package mou.terminal.web.repository.mysql.auth;

import mou.terminal.web.domain.mysql.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<User,Integer> {

    User findByUserId(String userId);
}
