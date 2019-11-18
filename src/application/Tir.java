package application;

public class Tir{
  private int x, y;

  /** Constructeur d'un tir
  *  @param px axe abscisses
  *  @param py axe ord
  */
  public Tir(int px, int py){
    this.x = px;
    this.y = py;
  }

/** getX()
* @return entier, valeur de x.
*/
  public int getX(){
    return x;
  }

  /** getY()
  * @return valeur de y.
  */
  public int getY(){
    return y;
  }

  /** evoluer() +1 à l'abscisse du Tir,
  * @return booleen: Tir est en dehors ou à l'interieur de l'arène.
  */
    public boolean evoluer(){
      this.x = this.x + 1;
      if (this.x > 10){
        return true;
      }
      else{
        return false;
      }
    }

  /** Créer String
  * @return string exemple: T(1, 2)
  */
    public String toString(){
      return "T("+this.x+","+this.y+")";
    }
}
