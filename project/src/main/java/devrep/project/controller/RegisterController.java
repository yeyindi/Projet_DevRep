package devrep.project.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
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
import devrep.project.util.SendMailUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	private final RegisterRepository registerRepository;
    private final SendMailUtils MailSender;


	public RegisterController(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
    	MailSender = new SendMailUtils();
    	MailSender.setInitData("devrepsar@gmail.com", "123456789@a");
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
	public boolean addRegister(@RequestBody Register register) {
		List<Register> l = (List<Register>)registerRepository.findAll();
		boolean exist = false;
		for(Register r:l) {
			if(register.getEmail().contentEquals(r.getEmail())) {
				exist = true;
			}
		}
		if(exist) {
			return false;
		}
		else {
			registerRepository.save(register);
			return true;
		}
	}
	
	@DeleteMapping("/api/register/{id}")
	  public void  deleteRegister(@PathVariable Long id) {
		Optional<Register> p = registerRepository.findById(id);
		if(p.isPresent()) {
			Register u = p.get();
			MailSender.simpleMailSend(u.getEmail()/*"devrepsar@gmail.com"*/, 
					"Confirmation", "Your inscription is canceled by the Super Administrator");
		}
		registerRepository.deleteById(id);
	}
	@GetMapping("/api/register/add/{id}")
	  public boolean  addRegister(@PathVariable Long id) {
		Optional<Register> p =registerRepository.findById(id);
		if(p.isPresent()) {
			Register r = p.get();
			r.setConfirmed();
			registerRepository.save(r);
    		MailSender.simpleMailSend(r.getEmail()/*"devrepsar@gmail.com"*/, "Confirmation", "Your inscription is saved, you can log in now");
			return true;
		}
		else {
			return false;
		}
	}
	
	
	@PostMapping("/api/login")
	public String login(@RequestBody Register register) {
		List<Register> l = (List<Register>)registerRepository.findAll();
		for(Register r:l) {
			if(register.getEmail().contentEquals("admin@gmail.com") && register.getPassword().contentEquals("admin")) {
				return JSONObject.quote("SuperAdmin");
				
			}
			if(r.getEmail().contentEquals(register.getEmail()) && r.getPassword().contentEquals(register.getPassword())) {
				System.out.println("in if: "+r.isConfirmed());
				if(r.isConfirmed() == true) {
					return JSONObject.quote("Admin");
				}
				else {
					return JSONObject.quote("AdminInvalid");
				}
			}
		}
		return JSONObject.quote("Unkown");
	}
	
}
