package Vererbung;

public abstract class Raubkatze extends Tier {

	
	private int danger;
	
	public Raubkatze(String pName, boolean pWeiblich, double pGewicht, int pDanger) {
		super(pName, pWeiblich, pGewicht);
		danger = pDanger;
	}
	
	@Override
	public void buersten() {
		// TODO Auto-generated method stub

	}
	
	public void bruellen() {
		
	}
	
	public boolean isRaubkatze() {
		boolean ergebnis = true;
		return ergebnis;
	}

}
