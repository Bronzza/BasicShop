package MateAcad.BasicShop.repositories;

import MateAcad.BasicShop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PrePersist;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <User, Long>{
    User findByUsername(String username);
}



