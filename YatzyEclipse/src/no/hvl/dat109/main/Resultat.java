package no.hvl.dat109.main;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity
@IdClass(ResultatID.class)
public class Resultat {
	@Id
	private int spillID;
	@Id
	@ManyToOne
	@JoinColumn(name = "spillerId", referencedColumnName = "spillerId")
	private int spillerID;

	private int enere;
	private int toere;
	private int treere;
	private int firere;
	private int femere;
	private int seksere;
	private int sum1;
	private int bonus;
	private int etPar;
	private int toPar;
	private int treLike;
	private int fireLike;
	private int litenStraight;
	private int storStraight;
	private int hus;
	private int sjanse;
	private int yatzy;
	private int totalSum;
	
	
	
	public int getSpillID() {
		return spillID;
	}
	
	public int getSpillerID() {
		return spillerID;
	}

	public int getEnere() {
		return enere;
	}
	public void setEnere(int enere) {
		this.enere = enere;
	}
	public int getToere() {
		return toere;
	}
	public void setToere(int toere) {
		this.toere = toere;
	}
	public int getTreere() {
		return treere;
	}
	public void setTreere(int treere) {
		this.treere = treere;
	}
	public int getFirere() {
		return firere;
	}
	public void setFirere(int firere) {
		this.firere = firere;
	}
	public int getFemere() {
		return femere;
	}
	public void setFemere(int femere) {
		this.femere = femere;
	}
	public int getSeksere() {
		return seksere;
	}
	public void setSeksere(int seksere) {
		this.seksere = seksere;
	}
	public int getSum1() {
		return sum1;
	}
	public void setSum1(int sum1) {
		this.sum1 = sum1;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getEtPar() {
		return etPar;
	}
	public void setEtPar(int etPar) {
		this.etPar = etPar;
	}
	public int getToPar() {
		return toPar;
	}
	public void setToPar(int toPar) {
		this.toPar = toPar;
	}
	public int getTreLike() {
		return treLike;
	}
	public void setTreLike(int treLike) {
		this.treLike = treLike;
	}
	public int getFireLike() {
		return fireLike;
	}
	public void setFireLike(int fireLike) {
		this.fireLike = fireLike;
	}
	public int getLitenStraight() {
		return litenStraight;
	}
	public void setLitenStraight(int litenStraight) {
		this.litenStraight = litenStraight;
	}
	public int getStorStraight() {
		return storStraight;
	}
	public void setStorStraight(int storStraight) {
		this.storStraight = storStraight;
	}
	public int getHus() {
		return hus;
	}
	public void setHus(int hus) {
		this.hus = hus;
	}
	public int getSjanse() {
		return sjanse;
	}
	public void setSjanse(int sjanse) {
		this.sjanse = sjanse;
	}
	public int getYatzy() {
		return yatzy;
	}
	public void setYatzy(int yatzy) {
		this.yatzy = yatzy;
	}
	public int getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}
	
	

}