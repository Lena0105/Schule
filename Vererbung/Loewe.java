package Vererbung;

public class Loewe extends Raubkatze {

	public Loewe(String name, boolean weiblich, double gewicht, int danger) {
		super(name, weiblich, gewicht, danger);
		// TODO Automatisch generierter Konstruktorstub
	}
	
	public void bruellen() {
		System.out.println("Roar!");
	}
	
}
