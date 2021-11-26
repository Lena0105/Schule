package Vererbung;

import Vererbung.Raubkatze;

public class Tiger extends Raubkatze {

		private int anzahlStreifen;
		
		public Tiger(String pName, boolean pWeiblich,double pGewicht, int pDanger, int pAnzahlStreifen) {
			super(pName, pWeiblich, pGewicht, pDanger);
			anzahlStreifen = pAnzahlStreifen;
		}
}
