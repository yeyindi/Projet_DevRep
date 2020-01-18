package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.interfaces.ConfRepository;
import devrep.project.model.Conf;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConfController {

	private final ConfRepository confRepository;

	public ConfController(ConfRepository confRepository) {
		this.confRepository = confRepository;
	}

	@GetMapping("/api/conf")
	public List<Conf> getUsers() {
		return (List<Conf>) confRepository.findAll();
	}

	@PostMapping("/api/conf")
	void addUser(@RequestBody Conf conf) {
		confRepository.save(conf);
	}

}
