import static java.lang.String.valueOf;

public class Die {
   //Fields:
   private int face;

   //EVC:
   public Die(int paramFace) {
       this.face = paramFace;
   }

   //DVC rolls a random number by default
    public Die() {
       int rolledFace = 1 + (int)(Math.random()*6);
       face = rolledFace;
    }

    //Getters:
    public int getFace() {
       return face;
    }

    //Setters:
    public void setFace(int newFace) {
       face = newFace;
    }

    @Override
    public String toString() {
       return valueOf(face);
    }
}
