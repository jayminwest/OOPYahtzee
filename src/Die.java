/**
 * Die is a simple class that holds numSides and face as attributes. numSides determines how many faces each die will have
 * and face is the number that the object rolls in the DVC.
 * @author Jaymin West
 */

import static java.lang.String.valueOf;

public class Die {
   //Fields:
   private int face;
   private static int numSides = Settings.getNumSides(); //must change this so it comes from settings now

   //EVC:
   public Die(int paramFace) {
       this.face = paramFace;
   }

   //DVC rolls a random number by default
    public Die() {
       int rolledFace = 1 + (int)(Math.random()*numSides);
       face = rolledFace;
    }

    //Getters:
    public int getFace() {
       return face;
    }
    public static int getNumFaces() { return numSides;}

    //Setters:
    public void setFace(int newFace) {
       face = newFace;
    }

    public void setNumSides(int numSides) { numSides = numSides;}

    @Override
    public String toString() {
       return valueOf(face);
    }
}
