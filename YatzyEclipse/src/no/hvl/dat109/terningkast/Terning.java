package no.hvl.dat109.terningkast;

public class Terning {
	
private int tall;

	public Terning() {
	}
	
	public Terning(int tall) {
		this.tall = tall;
	}
	
	public int getTall() {
		return tall;
	}

	public void setTall(int tall) {
		this.tall = tall;
	}

	public static int trill() {
		int tall = (int)(Math.random() *6)+1;
		return tall;
	}	

}
