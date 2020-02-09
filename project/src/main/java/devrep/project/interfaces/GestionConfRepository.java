package devrep.project.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devrep.project.model.GestionConf;

@Repository
public interface GestionConfRepository extends CrudRepository<GestionConf, Long>{}
