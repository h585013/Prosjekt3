package DAOogKlasse;

import javax.persistence.*;

@Entity
@Table(schema = "public", name="spiller")
public class Spiller {
	
	@Id
	private String brukernavn;
	
	public Spiller() {}
	
	public Spiller(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}
	
	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
}
