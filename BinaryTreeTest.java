package _test;
import linear.List;
import linear.ListWithViewer;
import gui.GUI;
import baeume.BinaryTree;
import baeume.TreeViewer;


public class BinaryTreeTest {
	public BinaryTree<Integer> suchbaum;
	
	public BinaryTreeTest(){
        suchbaum = new BinaryTree<Integer>(59);
        BinaryTree<Integer> b4= new BinaryTree<Integer>(4);
        BinaryTree<Integer> b34 = new BinaryTree<Integer>(34);
        BinaryTree<Integer> b16 = new BinaryTree<Integer>(16);
        BinaryTree<Integer> b7= new BinaryTree<Integer>(7);
        BinaryTree<Integer> b6 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> b12 = new BinaryTree<Integer>(12);
        BinaryTree<Integer> b18= new BinaryTree<Integer>(18);
        BinaryTree<Integer> b17= new BinaryTree<Integer>(17);
        BinaryTree<Integer> b53 = new BinaryTree<Integer>(53);
        BinaryTree<Integer> b45 = new BinaryTree<Integer>(45);
        BinaryTree<Integer> b78 = new BinaryTree<Integer>(78);
        BinaryTree<Integer> b62 = new BinaryTree<Integer>(62);
        BinaryTree<Integer> b61= new BinaryTree<Integer>(61);
        BinaryTree<Integer> b71 = new BinaryTree<Integer>(71);
        BinaryTree<Integer> b73 = new BinaryTree<Integer>(73);
        
        // neu Hinzugefügte Zahlen 2, 65, 83
        BinaryTree<Integer> b2 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> b65 = new BinaryTree<Integer>(65);
        BinaryTree<Integer> b83 = new BinaryTree<Integer>(83);

        b4.setLeftTree(b2);
        b71.setLeftTree(b65);
        b78.setRightTree(b83);
        
        suchbaum.setLeftTree(b4);
        b4.setRightTree(b34);
        b7.setLeftTree(b6);
        b7.setRightTree(b12);
        b16.setRightTree(b18);
        b18.setLeftTree(b17);
        b16.setLeftTree(b7);
        b34.setLeftTree(b16);
        b34.setRightTree(b53);
        b53.setLeftTree(b45);
        suchbaum.setRightTree(b78);
        b78.setLeftTree(b62);
        b62.setLeftTree(b61);
        b62.setRightTree(b71);
        b71.setRightTree(b73);
        TreeViewer.showTree(suchbaum, 600, 400);
	}
	
	
	// Rahmenmethode
	public int gibKnotenzahl() {
		return gibKnotenzahl(suchbaum);
	}
	
	private int gibKnotenzahl(BinaryTree<Integer> pBaum) {
		int anzahl = 0;
		if(pBaum.isEmpty()) {
			return 0;
		}
		int anzahlL = gibKnotenzahl(pBaum.getLeftTree());
		int anzahlR = gibKnotenzahl(pBaum.getRightTree());
		anzahl = anzahlL + anzahlR + 1;
		return anzahl;
	}
	
	
	// Rahmenmethode
	public int summe() {
		return summe(suchbaum);
	}

	private int summe(BinaryTree<Integer> pTree) {
		int summe = 0;
		if(pTree.isEmpty()) {
			return 0;
		}
		int wurzelzahl = pTree.getContent();
		int summeL = summe(pTree.getLeftTree());
		int summeR = summe(pTree.getRightTree());
		return wurzelzahl + summeL + summeR; 
	}
	
	
	//Rahmenmethode
	public int gibTiefe() {
		return gibTiefe(suchbaum);
	}
	
	private int gibTiefe(BinaryTree<Integer> pBaum) {
		int ergebnis = -1;
		if(pBaum.isEmpty()) {
			return ergebnis;
		}
		int tiefeLinks = gibTiefe(pBaum.getLeftTree());
		int tiefeRechts = gibTiefe(pBaum.getRightTree());
		ergebnis = tiefeLinks;
		if(ergebnis < tiefeRechts) {
			ergebnis = tiefeRechts;
		}
		ergebnis++;
		return ergebnis;
	}
	
	
	// Traversierungsverfahren
	
	//Rahmenmethode
		public ListWithViewer<Integer> preorder() {
			return preorder(suchbaum);
		}
		
	
	private ListWithViewer<Integer> preorder(BinaryTree<Integer> pTree){
		ListWithViewer<Integer> ergebnis = new ListWithViewer<>();
		if(pTree.isEmpty()) {
			return ergebnis;
		}
		int wurzelObjekt = pTree.getContent();
		ListWithViewer<Integer> linkeListe = preorder(pTree.getLeftTree());
		ListWithViewer<Integer> rechteListe = preorder(pTree.getRightTree());
		ergebnis.append(wurzelObjekt);
		ergebnis.concat(linkeListe);
		ergebnis.concat(rechteListe);
		return ergebnis;
	}
	
	
	//Rahmenmethode
			public ListWithViewer<Integer> inorder() {
				return inorder(suchbaum);
			}
			
		private ListWithViewer<Integer> inorder(BinaryTree<Integer> pTree){
			ListWithViewer<Integer> ergebnis = new ListWithViewer<>();
			if(pTree.isEmpty()) {
				return ergebnis;
			}
			int wurzelObjekt = pTree.getContent();
			ListWithViewer<Integer> linkeListe = inorder(pTree.getLeftTree());
			ListWithViewer<Integer> rechteListe = inorder(pTree.getRightTree());
			ergebnis.concat(linkeListe);
			ergebnis.append(wurzelObjekt);
			ergebnis.concat(rechteListe);
			return ergebnis;
		}
	
		
		//Rahmenmethode
				public ListWithViewer<Integer> postorder() {
					return postorder(suchbaum);
				}
				
			
			private ListWithViewer<Integer> postorder(BinaryTree<Integer> pTree){
				ListWithViewer<Integer> ergebnis = new ListWithViewer<>();
				if(pTree.isEmpty()) {
					return ergebnis;
				}
				int wurzelObjekt = pTree.getContent();
				ListWithViewer<Integer> linkeListe = postorder(pTree.getLeftTree());
				ListWithViewer<Integer> rechteListe = postorder(pTree.getRightTree());
				ergebnis.concat(linkeListe);
				ergebnis.concat(rechteListe);
				ergebnis.append(wurzelObjekt);
				return ergebnis;
			}
	

	public static void main(String[] args) {
		new GUI(new BinaryTreeTest());
	}
}
