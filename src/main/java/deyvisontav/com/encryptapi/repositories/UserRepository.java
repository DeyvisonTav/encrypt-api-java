package deyvisontav.com.encryptapi.repositories;

import deyvisontav.com.encryptapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
