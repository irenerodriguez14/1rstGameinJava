package test;

import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * test classe Tir
 *
 * A COMPLETER
 */

public class TestTir {

	/**
	 * test initial pour verifier le bon appel des methodes
	 */
	public void test_initial() {
		Tir t = new Tir(5, 6);
		assertEquals("test X", 5, t.getX());
		assertEquals("test Y", 6, t.getY());
		t.evoluer();
	}

	/**
	 * Évolution, le tir est à l'interieur de l'arène
	 */
	public void test_Evoluer_ResteDansArene() {
		// preparation des donnees
		Tir t = new Tir(6, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour false
		assertEquals("tir devrait rester dans arene", false, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 7, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	/**
	 * Évolution, le tir sort le l'arène
	 */
	public void test_Evoluer_SortirArene() {
		// preparation des donnees
		Tir t = new Tir(10, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour true car sortie de l arene
		assertEquals("tir devrait rester dans arene", true, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 11, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	/**
	* vérifie que la chaine toString() du Tir soit correcte
	*/

	public void test_toString_Correcte(){
		Tir t = new Tir(10, 5);
		// verifie string retournée
		assertEquals("pas la bonne string", "T(10,5)", t.toString());
	}

	/**
	 * méthode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestTir(), args);
	}

}
