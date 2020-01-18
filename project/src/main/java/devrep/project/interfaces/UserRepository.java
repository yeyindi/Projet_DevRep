package devrep.project.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devrep.project.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
