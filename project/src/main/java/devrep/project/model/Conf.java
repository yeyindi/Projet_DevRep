package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conf {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long conf_id;
	private final String title;
	private final String early_price;
	private final String early_date;
	private final String late_price;
	private final String late_date;
	private final String registration_type;
	
	public Conf(String title, String early_price, String early_date, String late_price, String late_date,
			String registration_type) {
		super();
		this.title = title;
		this.early_price = early_price;
		this.early_date = early_date;
		this.late_price = late_price;
		this.late_date = late_date;
		this.registration_type = registration_type;
	}
	
	public Conf() {
		this.title = "";
		this.early_price = "";
		this.early_date = "";
		this.late_price = "";
		this.late_date = "";
		this.registration_type = "";
	}

	public String getTitle() {
		return title;
	}


	public long getId() {
		return conf_id;
	}

	public void setId(long id) {
		this.conf_id = id;
	}

	public String getEarly_price() {
		return early_price;
	}

	public String getEarly_date() {
		return early_date;
	}

	public String getLate_price() {
		return late_price;
	}

	public String getLate_date() {
		return late_date;
	}

	public String getRegistration_type() {
		return registration_type;
	}	

}
