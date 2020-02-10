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
	private final String[] early_prices;
	private final String early_dateFrom;
	private final String early_dateTo;
	private final String[] late_prices;
	private final String late_dateFrom;
	private final String late_dateTo;
	private final String registration_type;
	
	public Conf(String title, String[] early_prices, String early_dateFrom,String early_dateTo, String[] late_prices, String late_dateFrom,
			String late_dateTo,String registration_type) {
		super();
		this.title = title;
		this.early_prices = early_prices;
		this.early_dateFrom = early_dateFrom;
		this.early_dateTo = early_dateTo;
		this.late_prices = late_prices;
		this.late_dateFrom = late_dateFrom;
		this.late_dateTo = late_dateTo;
		this.registration_type = registration_type;
	}
	
	public Conf() {
		this.title = "";
		this.early_prices = new String[5];
		this.early_dateFrom = "";
		this.late_prices = new String[5];
		this.late_dateFrom = "";
		this.early_dateTo = "";
		this.late_dateTo = "";
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

	public String getEarly_dateFrom() {
		return early_dateFrom;
	}

	public String[] getLate_price() {
		return late_prices;
	}

	public String getLate_dateFrom() {
		return late_dateFrom;
	}
	public String getLate_dateTo() {
		return late_dateTo;
	} 
	public String getEarly_dateTo() {
		return this.early_dateTo;
	}

	public String getRegistration_type() {
		return registration_type;
	}

	

}
