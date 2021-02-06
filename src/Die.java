import static java.lang.String.valueOf;

public class Die {
   //Fields:
   private int face;
   private static int numFaces = 6;

   //EVC:
   public Die(int paramFace) {
       this.face = paramFace;
   }

   //DVC rolls a random number by default
    public Die() {
       int rolledFace = 1 + (int)(Math.random()*numFaces);
       face = rolledFace;
    }

    //Getters:
    public int getFace() {
       return face;
    }
    public static int getNumFaces() { return numFaces;}

    //Setters:
    public void setFace(int newFace) {
       face = newFace;
    }

    public void setNumFaces(int numFaces) { numFaces = numFaces;}

    @Override
    public String toString() {
       return valueOf(face);
    }
}
