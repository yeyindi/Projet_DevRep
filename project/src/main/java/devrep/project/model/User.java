package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
     
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private final String title;
    private final String fName;
    private final String lName;
    private final String institution;
    private final String addr;
    private final String zip;
    private final String city;
    private final String country;
    private final String email;
    private final String phone;
    private final String type;
    private boolean confirmed;
    private String conf_id;
    
    public User(String title, String fName, String lName, String institution, String addr, String zip,
			String city, String country, String email, String phone, String type, String conf_id) {
		this.conf_id = conf_id;
		this.title = title;
		this.fName = fName;
		this.lName = lName;
		this.institution = institution;
		this.addr = addr;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.confirmed = false;
	}
    
    public User() {
    	this.conf_id = "";
		this.title = "";
		this.fName = "";
		this.lName = "";
		this.institution = "";
		this.addr = "";
		this.zip = "";
		this.city = "";
		this.country = "";
		this.email = "";
		this.phone = "";
		this.type = "";
		this.confirmed = false;
    }

	public long getId() {
		return user_id;
	}

	public void setId(long id) {
		this.user_id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getInstitution() {
		return institution;
	}

	public String getAddr() {
		return addr;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getType() {
		return type;
	}
	
	public boolean getConfirmed() {
		return this.confirmed;
	}
	public void setConfirmed() {
		this.confirmed = true;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", title=" + title + ", fName=" + fName + ", lName=" + lName + ", institution="
				+ institution + ", addr=" + addr + ", zip=" + zip + ", city=" + city + ", country=" + country
				+ ", email=" + email + ", phone=" + phone + ", type=" + type+", conf_id=" + conf_id+ "]";
	}

	public String getConf() {
		return conf_id;
	}

	public void setConf(String conf) {
		this.conf_id = conf;
	}
     
    
}
