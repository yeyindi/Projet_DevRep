package devrep.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GestionConf {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gestion_id;
	private final long register_id;
	private final long conf_id;
	
	public GestionConf(long gestion_id, long register_id) {
		super();
		this.conf_id = 0;
		this.gestion_id = gestion_id;
		this.register_id = register_id;
	}
	
	public GestionConf() {
		this.conf_id = 0;
		this.gestion_id = 0;
		this.register_id = 0;
	}

	public long getGestion_id() {
		return gestion_id;
	}

	public void setGestion_id(long gestion_id) {
		this.gestion_id = gestion_id;
	}

	public long getRegister_id() {
		return register_id;
	}

	public long getConf_id() {
		return conf_id;
	}

}
