package Vererbung;

public abstract class Tier {

	private String name;
	private boolean weiblich;
	private double gewicht;

	public Tier(String name, boolean weiblich, double gewicht) {
		super();
		this.name = name;
		this.weiblich = weiblich;
		this.gewicht = gewicht;
	}

	public abstract void buersten();


	public void fuettern(double pMenge) {
		gewicht += pMenge;
	}

	public boolean isRaubkatze() {
		boolean ergebnis = false;
		Tier aktTier = Zoo.zootiere.getContent();
		if(Raubkatze == aktTier) {
			ergebnis = true;
		}
		return ergebnis;
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


}
