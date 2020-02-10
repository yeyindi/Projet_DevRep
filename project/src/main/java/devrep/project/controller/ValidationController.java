package devrep.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import devrep.project.model.Conf;
import devrep.project.model.User;
import devrep.project.util.SendMailUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ValidationController {
	
	private final SendMailUtils MailSender;
	
	
	/* Classe pour la validation des inscriptions
	 * à voir si vraiment besoin , si on peut pas le foudre au userController
	 * 
	 * */
	public ValidationController(){
		MailSender = new SendMailUtils();
    	MailSender.setInitData("devrepsar@gmail.com", "123456789");
	}
	
	@PostMapping("/api/validation")
    public void validation(@RequestBody User user) {
		String text = user.getfName()+""+user.getlName()+" your demanded are sended to admin, please wait for validation"; 
    	MailSender.simpleMailSend("devrepsar@gmail.com", "test", text);
    	
    	
    	/* http request to get conf*/
    	final String uri = "http://localhost:8080/api/conf/{id}";
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", user.getConf());
         
        RestTemplate restTemplate = new RestTemplate();
        Conf c = restTemplate.getForObject(uri, Conf.class ,params );
        
        /* */
    	
    	String text2 = user.getfName()+""+user.getlName()+" want to join "+ c.getTitle() +"  please validation"; 
    	MailSender.simpleMailSend("devrepsar@gmail.com", "test", text2);
    }

}
