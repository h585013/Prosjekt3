package no.hvl.dat109.main;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ResultatID implements Serializable {
	@Column(name = "spillerID")
	private String spillerID; 
	@ManyToOne
	@Column(name = "spillID")
	@JoinColumn(name = "spillerID", referencedColumnName = "spillerID")
	private int spillID;
	
	public ResultatID() {
	}
	
	public ResultatID(String spillerID, int spillID) {
		this.spillerID = spillerID;
		this.spillID = spillID;
	} 
	
	public String getSpillerID() {
		return spillerID;
	}
	
	public int getSpillID() {
		return spillID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(!(o instanceof ResultatID)) return false;
		ResultatID that = (ResultatID) o;
		return Objects.equals(getSpillerID(), that.getSpillerID()) &&
				Objects.equals(getSpillID(), that.getSpillID());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getSpillerID(),getSpillID());
	}
	

}
