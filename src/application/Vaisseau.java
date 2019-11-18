package application;
import application.*;

public class Vaisseau{
  private int x, y;
  private Tir tirCourant;

/**
* Constructeur Vaisseau crée vaisseau dans la case (5,5)
*/
  public Vaisseau(){
    this.x = 5;
    this.y = 5;
    this.tirCourant = null;
  }

  /**
  * Constructeur d'un vaisseau, coordonnées spécifiées
  * @param px coordonnée abscisse
  * @param py coordonnée ordonnée
  */
  public Vaisseau(int px, int py){
    if ((px>10)||(py>10)||(px<0)||(py<0)){
      this.x = 5;
      this.y = 5;
    }
    else{
      this.x = px;
      this.y = py;
    }
  }

  /**
  * @return int, coordonnée abscisse
  */
  public int getX(){
    return x;
  }

  /**
  * @return int, coordonnée ordonnée
  */
  public int getY(){
    return y;
  }

  /**
  * @return Le tir courant
  */
  public Tir getTirCourant(){
    return tirCourant;
  }

  /**
  * Permet de deplacer le vaisseau, sans depasser les limites de l'arène
  */
  private void deplacer(int dx, int dy){
    int u = this.x + dx;
    if (u<=10 && u >= 0)
      this.x = u;
    int v = this.y + dy;
    if (v<=10 && v >= 0)
      this.y = v;
  }

  /**
  * Crée un tir s'il y a pas d'autres tirs déjà existants
  */
  public void tirer(){
    if (this.tirCourant == null){
      this.tirCourant = new Tir(this.x, this.y);
    }
  }

  /**
  * Decrit les actions à faire par rapport à la commande
  * @param a, Entier, répresente la commande donnée par le joueur.
  */
  public void faireAction(int a){
    switch (a){
      case 4:
        deplacer(-1, 0);
        break;
      case 6:
        deplacer(1, 0);
        break;
      case 8:
        deplacer(0, -1);
        break;
      case 2:
        deplacer(0, 1);
        break;
      case 5:
        tirer();
        break;
      default:
        deplacer(0,0);
        break;
    }
  }

  /**
  * Donne une valeur nulle au tir courant
  */
  public void detruireTir(){
    this.tirCourant=null;
  }

  /**
  * Analyse si le tir doit etre detruit ou pas
  */
  public void evoluerTir(){
    if (this.tirCourant != null){
      boolean t = this.tirCourant.evoluer();
      if (t == true){
        detruireTir();
      }
  }
}

  /**
  * @return String
  * si tir existant, exemple: Vaisseau(3,5)-T(4,5)
  * si tir inexistant, exemple: Vaisseau(3,5)
  */
  public String toString(){
    if (this.tirCourant == null){
      return "Vaisseau("+ this.x + "," + this.y + ")";
    }
    else{
    return "Vaisseau("+ this.x + "," + this.y + ")-T(" + tirCourant.getX() + "," + tirCourant.getY() +")";
  }
}

}
