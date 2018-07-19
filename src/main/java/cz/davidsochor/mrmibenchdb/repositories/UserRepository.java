package cz.davidsochor.mrmibenchdb.repositories;

import cz.davidsochor.mrmibenchdb.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
