package application;
import application.*;
import java.util.Scanner;

public class JeuShoot{
  Scanner sc = new Scanner(System.in);
  private Vaisseau joueur;
  private Monstre ennemi;
  private int score;
  private boolean perdu;

  /**
  * Crée un nouveau Jeu
  * avec Vaisseau sur (0,5)
  * Monstre sur(10,5)
  * Score à 0
  */
  public JeuShoot(){
    this.joueur = new Vaisseau(0, 5);
    this.ennemi = new Monstre(10, 5);
    this.score = 0;
    this.perdu = false;
  }

  /**
  * @return Vaisseau, represente le joueur
  */
  public Vaisseau getJoueur(){
    return this.joueur;
  }
  /**
  * @return Monstre, represente l'ennemi
  */
  public Monstre getEnnemi(){
    return this.ennemi;
  }

  /**
  * @return boolean, false si le joueur a perdu
  */
  public boolean getPerdu(){
    return this.perdu;
  }

  /**
  * @return int, donne le score
  */
  public int getScore(){
    return this.score;
  }

  /**
  * @param m, type Monstre
  * permet de changer directement les attributs du Monstre du jeu
  */
  public void setEnnemi(Monstre m){
    this.ennemi = m;
  }

  /**
  * @param v, type Vaisseau
  * permet de changer directement les attributs du Vaisseau(joueur)
  */
  public void setJoueur(Vaisseau v){
    this.joueur = v;
  }

  /**
  *
  * Appelle autres fonctions;
  * en cas de collision entre tir et monstre:
  *    score augmente de 1;
  *    Tir est detruit;
  *    Nouveau ennemi recrée sur la case (10,5)
  */
  public void gererCollision(){
    if (this.ennemi.avoirCollision(this.joueur.getTirCourant()) == true){
      this.score = this.score + 1;
      this.joueur.detruireTir();
      this.ennemi = new Monstre(10,5);
    }
  }

  /**
  * @param n, represente la commande pour le Vaisseau du joueur
  * permet d'enchainer la commande du joueur, faire evoluer le tir et le monstre et une eventuelle collission
  */
  public void evoluer(int n){
    this.joueur.faireAction(n);
    this.joueur.evoluerTir();
    gererCollision();
    this.ennemi.evoluer();
    gererCollision();
    if(this.ennemi.avoirTraverse()==true){
      this.perdu = true;
    }
  }

  /**
  * lecture commande du joueur
  * @return int, la commande
  */
  public int demanderJoueur(){
    int i = sc.nextInt();
    return i;
  }

  /**
  * Relance la lecture de commande
  */
  public void poursuivre(){
    int y = demanderJoueur();
    evoluer(y);
  }

  /**
  *
  * @return String, exemple: Vaisseau(4,6)
  *                          Monstre(10,5)
  */
  public String toString(){
    return this.joueur.toString() + "\n" + this.ennemi.toString() + "\n" +
  this.score + "\n";
  }

/**
* Main: creer nouveau jeu, repete lecture de commande jusqu'avoir perdu
* @param args, arguments du main
*/
public static void main(String [] args){
  JeuShoot jeu = new JeuShoot();
  while (jeu.getPerdu() != false){
    jeu.poursuivre();
  }
}

}
