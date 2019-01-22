
/**
 * Write a description of class Trex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trex extends Dinosaur
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Trex
     */
    public Trex()
    {
        // initialise instance variables
        super("Trex", 30);
    }

    public boolean attack(Dinosaur def)
    {
        if (def.getIsAlive() == true)
        {
            double prob = 0.0;
            if (def.getType().equals("Trex"))
            {
                prob = 0.6;
            }
            else if (def.getType().equals("Stego"))
            {
                prob = 0.9;
            }
            else if (def.getType().equals("Triceratops"))
            {
                prob = 0.9;
            }
            else {
                prob = 0.95;
            }
            if (Math.random() < prob)
            {
                this.update(true, def);
                return true;
            }
            else
            {
                this.update(false, def);
                return false;
            }
        }
        else{
            return true;
        }
    }
}
