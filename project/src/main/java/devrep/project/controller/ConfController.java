package devrep.project.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.text.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.exception.ConfNotFoundException;
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
	public List<Conf> getConfs() {
		return (List<Conf>) confRepository.findAll();
	}
	
	/*ca ne marche pas , j'essayer de recuperer les titre de conf via un param donne en url
	 * mais apparament il prefere le getMapping d'au dessus
	 * 
	 * */
	@GetMapping("/api/conf/")
	public Conf getConf(@RequestParam(value = "title", required = false) String title) {
		Iterator<Conf> i = confRepository.findAll().iterator();
		while(i.hasNext()) {
			Conf tmp = (Conf)i.next();
			if(tmp.getTitle() == title) {
				return tmp;
			}
		}
		return null;
	}
	
	@GetMapping("/api/conf/{id}")
	public Conf getConf(@PathVariable Long id) {
		return confRepository.findById(id).orElseThrow(() -> new ConfNotFoundException(id));
	}

	@PostMapping("/api/conf")
	void addUser(@RequestBody Conf conf) {
		confRepository.save(conf);
	}
	@GetMapping("/api/conf/types/{id}")
	public String getTypes(@PathVariable long id) throws ParseException{
		Optional<Conf> f = this.confRepository.findById(id);
		if(f.isPresent()) {
			Conf cf = f.get();
			SimpleDateFormat  format = new SimpleDateFormat("mm/dd/yyyy");
			Date d1 = format.parse(cf.getEarly_date());
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
