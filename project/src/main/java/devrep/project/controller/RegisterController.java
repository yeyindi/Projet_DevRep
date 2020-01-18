package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.interfaces.RegisterRepository;
import devrep.project.model.Register;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	private final RegisterRepository registerRepository;

	public RegisterController(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}

	@GetMapping("/api/register")
	public List<Register> getUsers() {
		return (List<Register>) registerRepository.findAll();
	}

	@PostMapping("/api/register")
	void addUser(@RequestBody Register register) {
		registerRepository.save(register);
	}

}
