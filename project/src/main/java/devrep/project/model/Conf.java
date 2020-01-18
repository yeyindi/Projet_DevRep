package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private final String title;
	private final String admin;
	
	public Conf(String title, String admin) {
		this.title = title;
		this.admin = admin;
	}
	
	public Conf() {
		this.title = "";
		this.admin = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getAdmin() {
		return admin;
	}
	

}
