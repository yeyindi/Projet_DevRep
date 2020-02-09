package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.exception.RegistrationNotFoundException;
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
	public void addUser(@RequestBody Register register) {
		registerRepository.save(register);
	}
	
	@GetMapping("/api/register/{id}")
	public Register findUser(@PathVariable Long id) {
		return registerRepository.findById(id).orElseThrow(() -> new RegistrationNotFoundException(id));
	}
	
	@DeleteMapping("/api/register/{id}")
	  void deleteRegister(@PathVariable Long id) {
		registerRepository.deleteById(id);
	}

}
