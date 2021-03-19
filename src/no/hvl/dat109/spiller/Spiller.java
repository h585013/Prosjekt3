package no.hvl.dat109.spiller;

public class Spiller {

	private String navn;
	 private int poeng;

	 public Spiller(String navn, int poeng) {
		
		this.navn = navn;
		this.poeng = poeng;
	}

	 
	 public void spillerPoeng(Spiller spiller) {
		 
		 spiller.getPoeng();
	 }
	 
	 
	 
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getPoeng() {
		return poeng;
	}

	public void setPoeng(int poeng) {
		this.poeng = poeng;
	}
	 
	 


	}
