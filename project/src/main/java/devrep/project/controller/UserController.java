package devrep.project.controller;

import java.util.List;

import org.aspectj.weaver.Iterators;
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
import java.util.Optional;
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
 
    /* Retourner tout les user qui sont confirmés*/
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
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    	String text = user.getfName()+" "+user.getlName()+" want to inscribe to conference "+user.getConf()
    			+ " click on this to validate http://localhost:8080/api/users/confirm/"+user.getId(); 
    	MailSender.simpleMailSend("devrepsar@gmail.com", "test", text);
    }
    
    
    /*
     * pour confirmer l'inscription d'un utilisateur, envoyer lui un lien sur la page de paiement
     */
    @GetMapping("api/users/confirm/{id}")
    public boolean confirmUser(@PathVariable long id) {
    	Optional<User> p = userRepository.findById(id);
    	if(p.isPresent()) {
    		User u = (User)p.get();
    		u.setConfirmed();
    		userRepository.save(u);
    		MailSender.simpleMailSend(u.getEmail()/*"devrepsar@gmail.com"*/, "Confirmation", "Your inscription is saved, you have to pay, click "
    				+ "this to pay  http://localhost:4200/inscription/pay/"+u.getfName()+"/"+u.getId());
    		return true;
    	}
    	else {
    		return false;
    	}
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