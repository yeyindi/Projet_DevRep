package devrep.project.model;

import java.util.List;
import java.util.ArrayList;
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
	private final String[] early_prices;
	private final String early_date;
	private final String[] late_prices;
	private final String late_date;
	private final String registration_type;
	
	public Conf(String title, String[] early_prices, String early_date, String[] late_prices, String late_date,
			String registration_type) {
		super();
		this.title = title;
		this.early_prices = early_prices;
		this.early_date = early_date;
		this.late_prices = late_prices;
		this.late_date = late_date;
		this.registration_type = registration_type;
	}
	
	public Conf() {
		this.title = "";
		this.early_prices = new String[3];
		this.early_date = "";
		this.late_prices = new String[3];
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

	public String[] getEarly_price() {
		return early_prices;
	}

	public String getEarly_date() {
		return early_date;
	}

	public String[] getLate_price() {
		return late_prices;
	}

	public String getLate_date() {
		return late_date;
	}

	public String getRegistration_type() {
		return registration_type;
	}	

}
