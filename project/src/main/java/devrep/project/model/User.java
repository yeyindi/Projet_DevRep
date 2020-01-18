package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
     
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
    
    public User(String title, String fName, String lName, String institution, String addr, String zip,
			String city, String country, String email, String phone, String type) {
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
	}
    
    public User() {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", fName=" + fName + ", lName=" + lName + ", institution="
				+ institution + ", addr=" + addr + ", zip=" + zip + ", city=" + city + ", country=" + country
				+ ", email=" + email + ", phone=" + phone + ", type=" + type + "]";
	}
     
    
}
