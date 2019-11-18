package application;
import application.*;

public class Monstre{
  private int x, y;
  private boolean deplacerHaut, etreMort;


  /**
  * Cree Montre, coordonnées specifiées
  * @param px, entier coordonnées abscisse
  * @param py, entier coordonnées ordonnée
  */
  public Monstre(int px, int py){
    if ((px<=10)&&(py>=0)&&(py<=10)&&(px>=0)){
       this.x = px;
       this.y = py;
       this.deplacerHaut = true;
       this.etreMort = false;
    }
    else{
      this.x = 10;
      this.y = 5;
    }
  }

  /**
  * @return boolean, Monstre est mort ou pas
  */
  public boolean getEtreMort(){
    return this.etreMort;
  }

  /**
  * @return int, coordonnée abscisse
  */
  public int getX(){
    return this.x;
  }

  /**
  * @return int, coordonnée ordonnée
  */
  public int getY(){
    return this.y;
  }

  /**
  * Deplace le Monstre par rapport à sa position actuelle, en prennant en compte les limites de l'arene.
  */
  public void evoluer(){
    if (this.etreMort == false){
      if (this.y == 0 && this.deplacerHaut == true){
        this.x = this.x - 1;
        this.deplacerHaut = false;
      }
      else if (this.y == 0 && this.deplacerHaut == false){
        this.y = this.y + 1;
      }
      else if (this.y == 10 && this.deplacerHaut == false){
        this.x = this.x - 1;
        this.deplacerHaut = true;
      }
      else if (this.y == 10 && this.deplacerHaut == true){
        this.y = this.y - 1;
      }
      else{
        if (this.deplacerHaut == true){
          this.y = this.y - 1;
        }
        else{
          this.y = this.y + 1;
        }
      }
    }
  }

  /**
  * analyse si le Monstre a traveré l'arène
  * @return boolean, monstre a traversé toute l'arène ou pas
  */
  public boolean avoirTraverse(){
    if (this.x == 0)
      return true;
    else return false;
  }

  /**
  * analyse si tir est sur la même case que monstre
  * @param untir de classe Tir, represente le tir lancé
  * @return boolean represente su Tir est sur la meme case
  */
  public boolean avoirCollision(Tir untir){
    if ((untir != null) && (this.x == untir.getX()) && (this.y == untir.getY())){
      this.etreMort = true;
      return true;
    }
    else
      return false;
  }

  /**
  * @return String, exemple: Monstre(3, 5)
  */
  public String toString(){
    return "Monstre(" + this.x + ", " + this.y + ")";
  }


}
