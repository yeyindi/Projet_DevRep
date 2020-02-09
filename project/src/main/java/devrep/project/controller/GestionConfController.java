package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.interfaces.GestionConfRepository;
import devrep.project.model.GestionConf;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GestionConfController {

	private final GestionConfRepository gestionConfRepository;

	public GestionConfController(GestionConfRepository gestionConfRepository) {
		this.gestionConfRepository = gestionConfRepository;
	}

	@GetMapping("/api/gestion")
	public List<GestionConf> getUsers() {
		return (List<GestionConf>) gestionConfRepository.findAll();
	}

	@PostMapping("/api/gestion")
	public void addUser(@RequestBody GestionConf user) {
		gestionConfRepository.save(user);
	}


}
