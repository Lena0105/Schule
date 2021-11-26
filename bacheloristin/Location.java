package bacheloristin;

import linear.List;

public class Location {

	private String ort;
	private String name;
	private double preis;
	private String ansprechpartner;
	private List<Location> sortedLocs;
	
	public Location(String pOrt, String pName) {
		ort = pOrt;
		name = pName;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public void aenderePreis(double pPreis) {
		preis = pPreis;
	}
	public String getAnsprechpartner() {
		return ansprechpartner;
	}
	
	public void aendereAnsprechpartner(String pAnsprechpartner) {
		ansprechpartner = pAnsprechpartner;
	}
	
	public double hoeheMonatsmiete(double pMonate) {
		double monatsmiete = 0;
		monatsmiete = preis * pMonate;
		return monatsmiete;
	}
	
}
