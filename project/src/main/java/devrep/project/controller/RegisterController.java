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

	
	/*Recuperer tout les registers*/
	@GetMapping("/api/register")
	public List<Register> getRegister() {
		return (List<Register>) registerRepository.findAll();
	}
	
	
	/*cherche le register avec l'id*/
	@GetMapping("/api/register/{id}")
	public Register findRegister(@PathVariable Long id) {
		return registerRepository.findById(id).orElseThrow(() -> new RegistrationNotFoundException(id));
	}
	
	/* ajouter un register */
	@PostMapping("/api/register")
	public void addRegister(@RequestBody Register register) {
		registerRepository.save(register);
	}
	
	@DeleteMapping("/api/register/{id}")
	  void deleteRegister(@PathVariable Long id) {
		registerRepository.deleteById(id);
	}
	@PostMapping("/api/login")
	public Boolean login(@RequestBody Register register) {
		List<Register> l = (List<Register>)registerRepository.findAll();
		for(Register r:l) {
			if(r.getEmail().contentEquals(register.getEmail()) && r.getPassword().contentEquals(register.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
}
