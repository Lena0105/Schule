package Vererbung;

import gui.GUI;

import linear.List;

public class Zoo {
	
	private List<Tier> zootiere;
	
	public Zoo() {
		zootiere = new List<>();
	}
	
	public void alleBuersten() {
		zootiere.toFirst();
		while(zootiere.hasAccess()) {
			Tier aktTier = zootiere.getContent();
			aktTier.buersten();
			zootiere.next();
		}
	}
	
	public void alleFuettern(double pMenge) {
		zootiere.toFirst();
		while(zootiere.hasAccess()) {
			Tier aktTier = zootiere.getContent();
			aktTier.fuettern(pMenge);
			zootiere.next();
		}
	}

	public void raubkatzenBruellen() {
		zootiere.toFirst();
		while(zootiere.hasAccess()) {
			Tier aktTier = zootiere.getContent();
			((Raubkatze)aktTier).bruellen();
			zootiere.next();
		}
	}
	
	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub
		Zoo z = new Zoo();
		new GUI(z);
	}

	private void zootiere() {
		zootiere.append(new Loewe("Leo", false, 100.5, 7)); 
		zootiere.append(new Loewe("Cali", true, 93.4, 5));
		zootiere.append(new Tiger("Amber", true, 52.3, 157, 8));
		zootiere.append(new Tiger("Brandy", true, 60.7, 140, 5));
		zootiere.append(new Nilpferd("Kalina", true, 1400.8));
		zootiere.append(new Nilpferd("Otto", false, 1800.3));
	}
	
	public List<Tier> getZootiere(){
		return zootiere;
	}
	
	public void setZootiere() {
		this.zootiere = zootiere;
	}
}
