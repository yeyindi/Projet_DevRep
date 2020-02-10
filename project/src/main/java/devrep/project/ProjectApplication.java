package devrep.project;

import java.io.File;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import devrep.project.interfaces.ConfRepository;
import devrep.project.interfaces.UserRepository;
import devrep.project.model.Conf;
import devrep.project.model.User;
import devrep.project.util.PdfUtils;
import devrep.project.util.SendMailUtils;
import devrep.project.util.TimerUtils;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository,ConfRepository confRepository) {
        return args -> {
<<<<<<< HEAD
        	Conf conf = new Conf("Spring conf",new String[]{"vip: 100€","normal: 10€"},"1/2/2020",new String[]{"vip: 200€","normal: 100€"},
        			"3/3/2020","test") ;
        	Conf conf2 = new Conf("Spring conf2",new String[]{"vip: 30€","normal: 20€"},"1/2/2020",new String[]{"vip: 200€","normal: 100€"},"3/3/2020","test");
=======
        	Conf conf = new Conf("Spring","10","20", null, null, null);
        	Conf conf2 = new Conf("Angular","100","200", null, null, null);
>>>>>>> 87cab0c4743cfdc8d67a697da8de7ffdf7c53a9e
        	confRepository.save(conf);
        	confRepository.save(conf2);
        	
        	/* test for mail sending with attachement */
        	/*PdfUtils p  = new PdfUtils();
        	p.pdfMake("Ye", "Yindi");
        	File f = new File("Facture_Ye_Yindi.pdf");
        	String text2 = "Ye Yindi had finish his paiement";
        	SendMailUtils mail = new SendMailUtils();
        	mail.setInitData("devrepsar@gmail.com", "123456789@a");
        	mail.attachedSend("devrepsar@gmail.com", "paiement confirmed", text2, f.getAbsolutePath());*/
        	
        	
        	/* initialisation de la base de donnée*/
        	String n = " test ";
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User("Sopena", name , name, name, name, name, name, name, name.toLowerCase() + "@domain.com", name, name);
                user.setConf(""+conf.getId());
                userRepository.save(user);
            });
            User user = new User("Sopena", n , n, n, n, n, n, n, n.toLowerCase() + "@domain.com", n, n);
            user.setConf(""+conf2.getId());
            userRepository.save(user);
            confRepository.findAll().forEach(System.out::println);
            userRepository.findAll().forEach(System.out::println);
            
            
            /*test for timer */
            //TimerUtils t = new TimerUtils();
            //t.addTimer(1, 100);
        };
    }

}
