package bacheloristin;

import java.util.ArrayList;
import linear.List;

import gui.GUI;

public class TheBacheloristin {

	private ArrayList<BacheloristinStaffel> staffelListe;
	private List<Location> sortedLocs;

	public TheBacheloristin() {
		sortedLocs = new List<>();
		staffelListe = new ArrayList<>();
		BacheloristinStaffel bs1 = new BacheloristinStaffel(2017);
		BacheloristinStaffel bs2 = new BacheloristinStaffel(2018);
		BacheloristinStaffel bs3 = new BacheloristinStaffel(2019);
		staffelListe.add(bs1);
		staffelListe.add(bs2);
		staffelListe.add(bs3);
		
		//Location l1 = new Location(sortedLocs);
		//sortedLocs.append(l1);

	}

	public boolean warSchonDabei(String pName) {
		boolean dabei = false;
		for(BacheloristinStaffel aktStaffel : staffelListe) {
			if(aktStaffel.istEnthalten(pName) == true) {
				dabei = true;
			}
		}
		return dabei;
	}
	
	private void initLocationListBacheloristin() {
		sortedLocs.append(new Location ("New York", "The Palace"));
		sortedLocs.append(new Location ("New York", "Better Day Spa"));
		sortedLocs.append(new Location ("San Francisco", "Spa Paradise"));
		sortedLocs.append(new Location ("Seattle", "The Grand Hotel"));
	}

	public static void main(String[]args) {
		TheBacheloristin tb = new TheBacheloristin();
		new GUI(tb);
	}

}
