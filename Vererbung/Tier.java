package Vererbung;

public abstract class Tier {

	private String name;
	private boolean weiblich;
	private double gewicht;
	
	public Tier(String pName, boolean pWeiblich, double pGewicht) {
		name = pName;
		pWeiblich = true;
		gewicht = pGewicht;
	}
	
	public abstract void buersten() {
		
	}
	
	@Override
	public String toString() {
		return "Tier [name=" + name + ", weiblich=" + weiblich + ", gewicht=" + gewicht + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWeiblich() {
		return weiblich;
	}

	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public void fuettern(double pMenge) {
		
	}
	
	public boolean isRaubkatze() {
		boolean ergebnis = false;
		return ergebnis;
	}
}
