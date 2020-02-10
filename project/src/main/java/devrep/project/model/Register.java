package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String email;
	private String password;
	private String confirm;
	private String super_admin;
	
	public Register(String email, String password, String confirm,String super_admin) {
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.super_admin = super_admin;
	}
	
	public Register() {
		this.email = "";
		this.password = "";
		this.confirm = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getSuper_admin() {
		return super_admin;
	}

	public void setSuper_admin(String super_admin) {
		this.super_admin = super_admin;
	}

}
