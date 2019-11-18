package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;


/**
 * test classe Vaisseau
 */

public class TestVaisseau {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Vaisseau v = new Vaisseau();
		v = new Vaisseau(1, 2);
		v.evoluerTir();
		v.faireAction(0);
		Tir t = v.getTirCourant();
		v.getX();
		v.getY();
		v.tirer();
	}

	/**
	*	test direct impossible pour methode déplacer
	*/

	/**
	*	Test tirer, création d'un tir
	*/
	public void test_tirer_CreerTir(){
		Vaisseau v = new Vaisseau();

		v.tirer();
		String g = "" + v.getTirCourant();
		// verifie cree nouveau tir à (5,5)
		assertEquals("tir", "T(5,5)", g);
	}

	/**
	*	Test tirer, vérifie les coordonnées du nouveau Tir
	*/
	public void test_tirer_CreerTirSurCoordVaisseau(){
		Vaisseau v = new Vaisseau(1,9);

		v.tirer();
		String g = "" + v.getTirCourant();
		// verifie cree nouveau tir à (1,9)
		assertEquals("tir pas crée sur la même case que le Vaisseau", "T(1,9)", g);
	}

	/**
	*	Test tirer, relancement d'un tir après destruction
	*/
	public void test_tirer_CreerDeuxiemeTir(){
		Vaisseau v = new Vaisseau(9, 2);
		v.tirer();
		v.evoluerTir();
		String g = "" + v.getTirCourant();
		assertEquals("tir devrait exister", "T(10,2)", g);
		v.evoluerTir();
		assertEquals("tir devrait exister", null, v.getTirCourant());
		v.tirer();
		g = "" + v.getTirCourant();
		assertEquals("deuxieme tir devrait exister", "T(9,2)", g);
	}

	/**
	*	Test tirer, crée un deuxième tir sans destruction
	*/
	public void test_tirer_creePasUnDeuxiemeTir(){
		Vaisseau v = new Vaisseau(7, 2);
		v.tirer();
		v.evoluerTir();
		v.evoluerTir();
		String g = "" + v.getTirCourant();
		assertEquals("tir devrait exister", "T(9,2)", g);
		v.tirer();
		g = "" + v.getTirCourant();
		assertEquals("Tir courant est pas le 2eme", "T(9,2)", g);
	}

	/**
	*	test faireAction, avec plusieures commandes
	*/
	public void test_faireAction_action(){
		Vaisseau v = new Vaisseau(0,9);
		//commande = 0
		v.faireAction(0);
		String g = "" + v.getX() + ", " + v.getY();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées (c=0)", "0, 9", g);

		//commande = 6
		v = new Vaisseau(0,9);
		v.faireAction(6);
		g = "" + v.getX() + ", " + v.getY();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées (c=6)", "1, 9", g);

		//commande = 2
		v = new Vaisseau(0,9);
		v.faireAction(2);
		g = "" + v.getX() + ", " + v.getY();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées(c=2)", "0, 10", g);

		//commande = 3
		v = new Vaisseau(0,9);
		v.faireAction(3);
		g = "" + v.getX() + ", " + v.getY();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées(c=3)", "0, 9", g);

		//commande = 4
		v = new Vaisseau(0,9);
		v.faireAction(4);
		g = "" + v.getX() + ", " + v.getY();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées(c=4)", "0, 9", g);


		//commande = 5
		v = new Vaisseau(0,9);
		v.faireAction(5);
		g = "" + v.getTirCourant();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées(c=5)", "T(0,9)", g);

		//commande = 8
		v = new Vaisseau(0,9);
		v.faireAction(8);
		g = "" + v.getX() + ", " + v.getY();
		//verifie changement des coordonnées
		assertEquals("Changement incorrect des coordonnées (c=6)", "0, 8", g);
}

		/**
		*	test destruirTir,
		*/
		public void test_detruireTir_ChangemNull(){
			Vaisseau v = new Vaisseau();
			assertEquals("Tir n'est pas null", null, v.getTirCourant());
			v.detruireTir();
			// Tir reste null
			assertEquals("Tir reste pas null", null, v.getTirCourant());
			// Tir non nul
			v.tirer();
			String g = "" + v.getTirCourant();
			assertEquals("Tir crée dans la case (5,5)", "T(5,5)", g);
			v.detruireTir();
			assertEquals("Tir transformé pas en null", null, v.getTirCourant());
		}

		/**
		*	test evoluerTir, verification changement coordonnées du tir
		*/
		public void test_evoluerTir_TirEvolue(){
			Vaisseau v = new Vaisseau(7,9);
			v.tirer();
			v.evoluerTir();
			//verification des coordonnées du tir apres une evolution
			String g = "" + v.getTirCourant();
			assertEquals("Tir n'a pas les bonnes coordonnées", "T(8,9)", g);
		}

		/**
		*	test evoluerTir, destruction après depasser limites de l'arène
		*/
		public void test_evoluerTir_Destruction(){
			Vaisseau v = new Vaisseau(10,9);
			v.tirer();
			v.evoluerTir();
			assertEquals("Tir n'est pas detruit", null, v.getTirCourant());
		}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestVaisseau(), args);
	}

}
