package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

/**
 * test classe Monstre
 *
 * A COMPLETER
 */

public class TestMonstre {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Monstre m = new Monstre(2, 3);
		boolean b = m.avoirCollision(new Tir(2, 2));
		b = m.avoirTraverse();
		m.evoluer();
		b = m.getEtreMort();
		int x = m.getX();
		int y = m.getY();
	}

	/**
	*	test evoluer, test le deplacement du Monstre
	*/
	public void test_evoluer_Deplacement(){
		int i;
		//verification coordonnées vers la gauche avec y = 10 (deplacerHaut = true)
		Monstre m = new Monstre(4, 10);
		m.evoluer();
		assertEquals("Pas le bon deplacement(vers la gauche)", "Monstre(4, 9)", m.toString());
		//verification coordonnées vers le haut
		m.evoluer();
		assertEquals("Pas le bon deplacement(vers le haut)", "Monstre(4, 8)", m.toString());

		//verification coordonnées vers la gauche avec y = 0
		m = new Monstre(4, 0);
		m.evoluer();
		assertEquals("Pas le bon deplacement(vers la gauche)(y = 0)", "Monstre(3, 0)", m.toString());
		//verification changement direction
		m.evoluer();
		assertEquals("Pas le bon deplacement(vers le bas)", "Monstre(3, 1)", m.toString());
		m.evoluer();
		assertEquals("Mauvaise direction", "Monstre(3, 2)", m.toString());
		for (i=1; i<9; i++)
			m.evoluer();
		//verification coordonnées vers la gauche avec y = 10 (deplacerHaut = false)
		m.evoluer();
		assertEquals("Pas le bon deplacement(vers la gauche)(y = 10)", "Monstre(2, 10)", m.toString());
		//verification changement de direction vers le haut
		m.evoluer();
		assertEquals("Pas le bon deplacement(vers la gauche)(y = 10)", "Monstre(2, 9)", m.toString());
	}

	/**
	*	test avoirTraverse, quand le monstre est traversé l'arène
	*/
	public void test_avoirTraverse_booleanCorrect(){
	Monstre	m = new Monstre(1,0);
	//Pas à la fin
	boolean t = m.avoirTraverse();
	assertEquals("Faux, le Monstre n'a pas traversé toute l'arène", false, t);
	//Traversé l'arène
	m.evoluer();
	t = m.avoirTraverse();
	assertEquals("Faux, le Monstre a traversé toute l'arène", true, t);
	}

	/**
	*	test avoirCollision avec tir
	*/
	public void test_avoirCollision_memeCase(){
		Tir t = new Tir(5,5);
		Monstre m = new Monstre(5, 6);
		m.evoluer();
		assertEquals("Faux, il y a eu une collision", true, m.avoirCollision(t));
	}

	/**
	*	test avoirCollision, deplacement ordonné des objets
	*/
	public void test_avoirCollision_diffY(){
		Tir t = new Tir(5,5);
		Monstre m = new Monstre(5, 6);
		assertEquals("Faux, il y a eu une collision", false, m.avoirCollision(t));
	}

	/**
	*	test avoirCollision, deplacement ordonné des objets
	*/
	public void test_avoirCollision_diffX(){
		Tir t = new Tir(6,6);
		Monstre m = new Monstre(5, 6);
		assertEquals("Faux, il y a eu une collision", false, m.avoirCollision(t));
	}


	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestMonstre(), args);
	}

}
