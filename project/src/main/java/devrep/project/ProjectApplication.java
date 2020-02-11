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
import devrep.project.util.LoggerUtils;
import devrep.project.util.PdfUtils;
import devrep.project.util.SendMailUtils;
import devrep.project.util.TimerUtils;
import org.springframework.data.util.Pair;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository,ConfRepository confRepository) {
        return args -> {
        	Conf conf = new Conf("Spring conf",new String[] {"normal: 100","vip: 200"},"1-2-2020",new String[]{"vip: 200â‚¬","normal: 100â‚¬"},
        			"3-3-2020","test") ;
        	Conf conf2 = new Conf("Spring conf2",new String[]{"vip: 30¢ã","normal: 20¢ã"},"1-2-2020",new String[]{"vip: 200¢ã","normal: 100¢ã"},"3-3-2020","test");
        	confRepository.save(conf);
        	confRepository.save(conf2);
        	
        	/* test for logger */
        	
        	LoggerUtils logger = new LoggerUtils();
        	logger.LogSuccess("success");
        	logger.LogFail("Fail");
        	
        	/* test for mail sending with attachement */
        	/*PdfUtils p  = new PdfUtils();
        	p.pdfMake("Ye", "Yindi");
        	File f = new File("Facture_Ye_Yindi.pdf");
        	String text2 = "Ye Yindi had finish his paiement";
        	SendMailUtils mail = new SendMailUtils();
        	mail.setInitData("devrepsar@gmail.com", "123456789@a");
        	mail.attachedSend("devrepsar@gmail.com", "paiement confirmed", text2, f.getAbsolutePath());*/
        	
        	
        	/* initialisation de la base de donn¨¦e*/
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
