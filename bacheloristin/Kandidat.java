package bacheloristin;

public class Kandidat {

	private String name;
	private int gebDatum;
	private boolean weiblich;
	private int quotenPunkte;
	private boolean nochDabei;
	public String getName() {
		return name;
	}
	
	public Kandidat(String pName, int pGebDatum, boolean pWeiblich) {
		name = pName;
		gebDatum = pGebDatum;
		weiblich = pWeiblich;
		quotenPunkte = 0;
		nochDabei = true;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getGebDatum() {
		return gebDatum;
	}
	public void setGebDatum(int gebDatum) {
		this.gebDatum = gebDatum;
	}
	public int getQuotenPunkte() {
		return quotenPunkte;
	}
	public void setQuotenPunkte(int quotenPunkte) {
		this.quotenPunkte = quotenPunkte;
	}
	public boolean isWeiblich() {
		return weiblich;
	}
	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}
	public boolean isNochDabei() {
		return nochDabei;
	}
	public void setNochDabei(boolean nochDabei) {
		this.nochDabei = nochDabei;
	}
	
	public void fliegtRaus() {
		nochDabei = false;
	}
	
	public void resetQuotenPunkte() {
		quotenPunkte = 0;
	}
	
	public void erhoeheQuotenPunkte(int pQuotenPunkte) {
		quotenPunkte += pQuotenPunkte;
	}
	
	public void senkeQuotenPunkte(int pQuotenPunkte) {
		quotenPunkte -= pQuotenPunkte;
		if(quotenPunkte <= 0) {
			quotenPunkte = 0;
		}
	}
	
	public boolean istAelterAls(Kandidat pAnderer) {
		boolean ergebnis = false;		
		if(gebDatum<=pAnderer.getGebDatum()) {
			ergebnis = true;
		}
		else {
			ergebnis = false;
		}
		return ergebnis;
	}

	@Override
	public String toString() {
		return "Kandidat [name=" + name + ", gebDatum=" + gebDatum + ", weiblich=" + weiblich + ", quotenPunkte="
				+ quotenPunkte + ", nochDabei=" + nochDabei + "]";
	}	
}
