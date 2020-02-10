package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.interfaces.UserRepository;
import devrep.project.model.User;
import devrep.project.util.SendMailUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    private final SendMailUtils MailSender;
    
    public UserController(UserRepository userRepository) {
    	this.userRepository = userRepository;
    	MailSender = new SendMailUtils();
    	MailSender.setInitData("devrepsar@gmail.com", "123456789@a");
    }
 
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/api/users")
    public void addUser(@RequestBody User user) {
    	String text = user.getfName()+""+user.getlName()+" your demanded are sended to admin, please wait for validation"; 
    	MailSender.simpleMailSend("devrepsar@gmail.com", "test", text);
        userRepository.save(user);
    }
    
    @PostMapping("/api/users/{conf_id}")
    public void addUser(@PathVariable String conf_id,@RequestBody User user) {
    	user.setConf(conf_id);
    	userRepository.save(user);
    }
    
    @DeleteMapping("/api/users/{id}")
	  void deleteUser(@PathVariable Long id) {
    	userRepository.deleteById(id);
	}
}
