package no.hvl.dat109.main;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ResultatID implements Serializable {
	@ManyToOne
	@Column(name = "brukernavn")
	@JoinColumn(name = "brukernavn", referencedColumnName = "brukernavn")
	private String brukernavn; 
	@ManyToOne
	@Column(name = "spillID")
	@JoinColumn(name = "spillID", referencedColumnName = "spillID")
	private int spillID;
	
	public ResultatID() {
	}
	
	public ResultatID(String brukernavn, int spillID) {
		this.brukernavn = brukernavn;
		this.spillID = spillID;
	} 
	
	public String getBrukernavn() {
		return brukernavn;
	}
	
	public int getSpillID() {
		return spillID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(!(o instanceof ResultatID)) return false;
		ResultatID that = (ResultatID) o;
		return Objects.equals(getBrukernavn(), that.getBrukernavn()) &&
				Objects.equals(getSpillID(), that.getSpillID());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getBrukernavn(),getSpillID());
	}
	

}
