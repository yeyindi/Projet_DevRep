package devrep.project;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import devrep.project.interfaces.ConfRepository;
import devrep.project.interfaces.UserRepository;
import devrep.project.model.Conf;
import devrep.project.model.User;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository,ConfRepository confRepository) {
        return args -> {
        	Conf conf = new Conf("Spring conf",new String[]{"vip: 100€","normal: 10€"},"1/1/2020","1/2/2020",new String[]{"vip: 200€","normal; 100€"},"2/2/2020",
        			"3/3/2020","test") ;
        	Conf conf2 = new Conf("Spring conf2",new String[]{"vip: 30€","normal; 20€"},"1/1/2020","1/2/2020",new String[]{"vip: 200€","normal; 100€"},
        			"2/2/2020","3/3/2020","test");
        	confRepository.save(conf);
        	confRepository.save(conf2);
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
        };
    }

}
