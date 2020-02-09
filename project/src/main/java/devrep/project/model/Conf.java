package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conf {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String conf_id;
	private final String title;
	private final String early;
	private final String late;
	
	public Conf(String title, String early, String late) {
		this.title = title;
		this.early = early;
		this.late = late;
	}
	
	public Conf() {
		this.title = "";
		this.early = "";
		this.late = "";
	}

	public String getTitle() {
		return title;
	}

	public String getEarly() {
		return early;
	}

	public String getLate() {
		return late;
	}

	public String getId() {
		return conf_id;
	}

	public void setId(String id) {
		this.conf_id = id;
	}

	

}
