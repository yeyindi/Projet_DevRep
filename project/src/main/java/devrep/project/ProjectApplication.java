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
        	Conf conf = new Conf("Spring conf","10","20");
        	Conf conf2 = new Conf("Spring conf2","100","200");
        	confRepository.save(conf);
        	confRepository.save(conf2);
        	String n = " test ";
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User("Sopena", name , name, name, name, name, name, name, name.toLowerCase() + "@domain.com", name, name);
                user.setConf(conf);
                userRepository.save(user);
            });
            User user = new User("Sopena", n , n, n, n, n, n, n, n.toLowerCase() + "@domain.com", n, n);
            user.setConf(conf2);
            userRepository.save(user);
            confRepository.findAll().forEach(System.out::println);
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
