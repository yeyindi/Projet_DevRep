package devrep.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.interfaces.ConfRepository;
import devrep.project.model.Conf;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConfController {

	private final ConfRepository confRepository;

	public ConfController(ConfRepository confRepository) {
		this.confRepository = confRepository;
	}

	@GetMapping("/api/conf")
	public List<Conf> getUsers() {
		return (List<Conf>) confRepository.findAll();	
	}

	@PostMapping("/api/conf")
	void addUser(@RequestBody Conf conf) {
		confRepository.save(conf);
	}
	
	@GetMapping("/api/conf/types/{id}")
	public String[] getTypes(@PathVariable long id) throws ParseException{
		Optional<Conf> f = this.confRepository.findById(id);
		if(f.isPresent()) {
			Conf cf = f.get();
			SimpleDateFormat  format = new SimpleDateFormat("mm/dd/yyyy");
			Date d1 = format.parse(cf.getEarly_dateTo());
			Date d2 = new Date();
			if(d2.after(d1)) {
				return cf.getLate_price();
			}
			else {
				return cf.getEarly_price();
			}
		}
		else {
			return null;
		}
		
	}

}
