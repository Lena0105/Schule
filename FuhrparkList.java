package _test.linear.fuhrpark;

import gui.GUI;
//import jdk.internal.misc.FileSystemOption;
import linear.List;
import linear.ListWithViewer;

public class FuhrparkList {
	private List<Lastwagen> lastwagenList;
	private List<Fahrt> fahrtenList;
	private Lastwagen A, B, C, D, E;

	public FuhrparkList() {
		lastwagenList = new ListWithViewer<>();
		A = new Lastwagen("A",40);
		A.zuladen(20);
		B = new Lastwagen("B",50);
		B.zuladen(20);
		C = new Lastwagen("C",40);
		C.zuladen(10);
		D = new Lastwagen("D",30);
		D.zuladen(30);
		E = new Lastwagen("E",40);
		E.zuladen(30);
		lastwagenList.append(A);
		lastwagenList.append(B);
		lastwagenList.append(C);
		lastwagenList.append(D);
		lastwagenList.append(E);
		fahrtenList = new ListWithViewer<>();
		Fahrt A1 = new Fahrt("Max", A, 20);
		Fahrt B1 = new Fahrt("Tom", B, 30);
		Fahrt C1 = new Fahrt("Otto", C, 40);
		Fahrt A2 = new Fahrt("Otto", A, 25);
		Fahrt B2 = new Fahrt("Tom", B, 15);
		fahrtenList.append(A1);
		fahrtenList.append(B1);
		fahrtenList.append(C1);
		fahrtenList.append(A2);
		fahrtenList.append(B2);
	}

	/**
	 * fuegt einen Lastwagen zum lastwagenList hinzu.
	 * Seine Beladung soll 0 sein.
	 * @param pKennzeichen
	 * @param pMaxBeladung
	 */
	public void lastwagenHinzufuegen(String pKennzeichen, double pMaxBeladung){
		Lastwagen neu = new Lastwagen(pKennzeichen, pMaxBeladung);
		lastwagenList.append(neu);
	}

	public void fahrtHinzufuegen(String pFahrer, Lastwagen pLastwagen, int pKm){
		Fahrt f = new Fahrt(pFahrer, pLastwagen, pKm);
		fahrtenList.append(f);
	}

	/**
	 * gibt zurueck, wie viele Lastwagen maximal pGewicht geladen haben.
	 * Fuer pGewicht == 20 sind das z.B. 3.
	 * @param pGewicht
	 * @return
	 */
	public int anzahlMitMaxBeladung(double pGewicht){
		int ergebnis = 0;
		for(lastwagenList.toFirst(); lastwagenList.hasAccess(); lastwagenList.next()) {
			Lastwagen akt = lastwagenList.getContent();
			double aktBeladung = akt.getBeladung();
			if(aktBeladung == pGewicht) {
				ergebnis++;
			}
		}
		return ergebnis;
	}


	/**
	 * sucht einen Lastwagen, der pGewicht laden kann und gibt ihn zurueck.
	 * Der Lastwagen wird aus lastwagenList entfernt.
	 * @param pGewicht
	 * @return
	 */
	public Lastwagen lastwagenSuchen(double pGewicht){
		for(lastwagenList.toFirst(); lastwagenList.hasAccess(); lastwagenList.next()) {
			Lastwagen akt = lastwagenList.getContent();
			double aktMax = akt.getMaxBeladung();
			double aktB = akt.getBeladung();
			double frei = aktMax - aktB - pGewicht;
			if(frei >= 0) {
				lastwagenList.remove();
				return akt;
			}
		}
		return null;
	}									

	/**
	 * gibt den Lastwagen zurueck, der am wenigsten gefahren ist.
	 * Dafuer braucht man eine geeignete Hilfsmethode!
	 * 
	 * Am wenigsten gefahren ist Lastwagen C.
	 * @return
	 */
	public Lastwagen istAmWenigstenGefahren(){		// FUNKTIONIERT NICHT!!!
		lastwagenList.toFirst();
		Lastwagen min = lastwagenList.getContent();
		System.out.println(min);
		int minKM = anzahlKM(min);
		System.out.println(minKM);
		
		for(lastwagenList.toFirst(); lastwagenList.hasAccess(); lastwagenList.next()) {
			Lastwagen aktL = lastwagenList.getContent();
			System.out.println(aktL);
			int aktKM = anzahlKM(aktL);
			System.out.println(aktKM);
			if(aktKM < minKM) {
				minKM = aktKM;
				System.out.println(minKM);
				min = aktL;
				System.out.println(min);
			}
		}
		return min;
	}

	//Hilfsmethode für istAmWenigstenGefahren()
	public int anzahlKM(Lastwagen pLastwagen) {
		int km = 0;
		for(fahrtenList.toFirst(); fahrtenList.hasAccess(); fahrtenList.next()) {
			Fahrt aktF = fahrtenList.getContent();
			int aktKM = aktF.getKm();
			Lastwagen aktL = aktF.getLastwagen();
			if(aktL == pLastwagen) {
				aktKM += km;
			}
		}
		return km;
	}

	/**
	 * misst, wie viel die Lastwagen insgesamt geladen haben 
	 * und packt dann die ersten Lastwagen ganz voll.
	 * Die voll beladenen Lastwagen werden als List zurueckgegeben,
	 * die anderen Lastwagen bleiben in lastwagenList.
	 * 
	 * Am Ende wird zurueckgegeben: (A,40/40), (B,50/50), (C,20/40)
	 * Im lastwagenList bleiben: (D,0/30), (E,0/30)
	 */
	public List<Lastwagen> aufMoeglichstWenigeLastwagenUmladen(){
		List<Lastwagen> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}

	public static void main(String[] args) {
		new GUI(new FuhrparkList());
	}
}
