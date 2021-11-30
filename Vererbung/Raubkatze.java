package Vererbung;

public abstract class Raubkatze extends Tier {
	
	private int danger;

	public Raubkatze(String name, boolean weiblich, double gewicht, int danger) {
		super(name, weiblich, gewicht);
		this.danger = danger;
	}
	
	public abstract void bruellen();

	@Override
	public void buersten() {
		System.out.println("Purrpurrpurr!");
	}
	
	
	public boolean isRaubkatze() {
		boolean ergebnis = true;
		return ergebnis;
	}

}
