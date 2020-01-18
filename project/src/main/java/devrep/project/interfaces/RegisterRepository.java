package devrep.project.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devrep.project.model.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long>{}
