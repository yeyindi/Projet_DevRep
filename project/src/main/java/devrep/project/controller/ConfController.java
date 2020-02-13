package devrep.project.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.text.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devrep.project.exception.ConfNotFoundException;
import devrep.project.interfaces.ConfRepository;
import devrep.project.model.Conf;

import org.json.JSONObject;
import org.springframework.data.util.Pair;

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
	
	@DeleteMapping("/api/conf/{id}")
	public void deleteConf(@PathVariable Long id) {
		this.confRepository.deleteById(id);
		
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
		System.out.println(conf.getEarly_date()+"\n"+
				conf.getEarly_price()+"\n"+conf.getLate_date()+"\n"+conf.getLate_price()+"\n"+conf.getTitle());
		confRepository.save(conf);
	}
	@GetMapping("/api/conf/types/{id}")
	public String getTypes(@PathVariable long id){
		Optional<Conf> f = this.confRepository.findById(id);

		if(f.isPresent()) {
			Conf cf = f.get();
			SimpleDateFormat  format = new SimpleDateFormat("yyyy-mm-dd");
			Date d1;
			try {
				d1 = format.parse(cf.getEarly_date());
				Date d2 = new Date();
				if(d2.after(d1)) {
					return JSONObject.quote(cf.getLate_price());
				}
				else {
					return JSONObject.quote(cf.getEarly_price());
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		}
		else {
			return null;
		}
		
	}

}
