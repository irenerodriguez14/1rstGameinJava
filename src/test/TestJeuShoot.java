package test;

import libtest.*;
import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de test de JeuShoot
 */
public class TestJeuShoot {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		JeuShoot j = new JeuShoot();
		Monstre monstre = j.getEnnemi();
		Vaisseau v = j.getJoueur();
		int s = j.getScore();
		boolean b=j.getPerdu();
		j.evoluer(0);
		j.setEnnemi(new Monstre(2,2));
		j.setJoueur(new Vaisseau(2,2));
		assertEquals("score nul au depart",s,0);
	}

	/**
	*	test nouveau jeu
	*/
	public void test_gererCollision_avantCollision(){
		JeuShoot js = new JeuShoot();
		Vaisseau v = js.getJoueur();
		Monstre m = js.getEnnemi();
		assertEquals("monstre pas cree", "Monstre(10, 5)", m.toString());
		v.tirer();
		// avant collision
		assertEquals("wrong score", 0, js.getScore());
	}

	/**
	* test avant collission
	*/
	public void test_gererCollision_tousLesAttributs(){
		JeuShoot js = new JeuShoot();
		Monstre m = js.getEnnemi();
		Vaisseau v = js.getJoueur();
		assertEquals("monstre pas cree", "Monstre(10, 5)", m.toString());
		v.tirer();
		// avant collision
		assertEquals("wrong score", 0, js.getScore());
	}

	/**
	*	test apres collision
	*	collision: destruction du tir et renouvelle Monstre.
	*/
	public void test_gererCollision_apresCOllision(){
		JeuShoot js = new JeuShoot();
		Vaisseau v = new Vaisseau(5,6);
		Monstre m = new Monstre(6,6);
		js.setEnnemi(m);
		js.setJoueur(v);
		v = js.getJoueur();
		m = js.getEnnemi();
		v.tirer();
		js.evoluer(1);
		assertEquals("Tir n'est pas null après collission", null, v.getTirCourant());
		m = js.getEnnemi();
		assertEquals("Monstre pas tué", "Monstre(10, 4)", m.toString());
		assertEquals("Tir pas detruit", null, v.getTirCourant());
	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeuShoot(), args);
	}

}
