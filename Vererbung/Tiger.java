package Vererbung;

public class Tiger extends Raubkatze {
	
	private int anzahlStreifen;

	public Tiger(String name, boolean weiblich, double gewicht, int anzahlStreifen, int danger) {
		super(name, weiblich, gewicht, danger);
		this.anzahlStreifen = anzahlStreifen;
	}
	
	public void bruellen() {
		System.out.println("Chchchau!");
	}

	public int getAnzahlStreifen(int pAnzahl) {
		return anzahlStreifen;
	}
	
}
