package devrep.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.exception.UserNotFoundException;
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
 
    /* Retourner tout les user*/
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    /* Retourner un user avec l'id*/
    @GetMapping("/api/users/{id}")
	public User findUser(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
 
    /*ajouter un utilisateur
     * envoie le mail en meme temps ( peut etre pas ici on verra )
     * 
     * */
    @PostMapping("/api/users")
    public void addUser(@RequestBody User user) {
    	String text = user.getfName()+" "+user.getlName()+" your demanded are sended to admin, please wait for validation"; 
    	MailSender.simpleMailSend("devrepsar@gmail.com", "test", text);

        userRepository.save(user);
    }
    
    /* Ajout de user avec un conf id mais apparament tu m'as dit inutile
     * mais en cas ou je le laisse*/
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