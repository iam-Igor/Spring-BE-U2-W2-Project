package ygorgarofalo.SpringU2W2Project.reposiories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ygorgarofalo.SpringU2W2Project.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
